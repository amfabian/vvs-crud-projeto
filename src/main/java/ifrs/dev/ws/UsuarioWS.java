package ifrs.dev.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ifrs.dev.model.Usuario;

@Path("/usuario")
public class UsuarioWS {

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Usuario create (@FormParam("login") String login,
                            @FormParam("password") String password,
                            @FormParam("email") String email) {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.persistAndFlush();
        return usuario;    
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> list(){
        return Usuario.listAll();
    }
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario find(@PathParam("id") Long id){
        return Usuario.findById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        System.out.println("entrou  path delet ");
        Usuario.deleteById(id);
        System.out.println("EXECUTOU delet ");
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario update(@PathParam("id") Long id, @FormParam("login") String login,
                            @FormParam("password") String password,
                            @FormParam("email") String email){
        Usuario usuario = Usuario.findById(id);
        if (email != null) usuario.setEmail(email);
        if (login != null) usuario.setLogin(login);
        if (password != null) usuario.setPassword(password);
        usuario.persistAndFlush();
        return usuario;                           
    }

    @PUT //EXCLUSIVO DO USUARIO
    @Path("/setAdmin/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario setAdmin(@PathParam("id") Long id){
        Usuario usuario = Usuario.findById(id);
        usuario.setAdmin(true);
        usuario.persistAndFlush();
        return usuario;
    }

}
