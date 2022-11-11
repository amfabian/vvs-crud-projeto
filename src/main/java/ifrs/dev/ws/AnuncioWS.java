package ifrs.dev.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ifrs.dev.model.Anuncio;
import ifrs.dev.model.Manga;
import ifrs.dev.model.Usuario;

@Path("/anuncio")
public class AnuncioWS {
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Anuncio create(@FormParam("manga_id") Long manga_id,
                            @FormParam("user_id") Long user_id,
                            @FormParam("desc") String desc){
        Anuncio anuncio = new Anuncio();
        anuncio.setDescricao(desc);
        Manga manga = Manga.findById(manga_id);
        anuncio.setManga(manga);
        anuncio.persistAndFlush();
                                
        Usuario user = Usuario.findById(user_id);
        if (user == null)
            throw new BadRequestException("User not found");

        user.addAnuncios(anuncio);
        user.persistAndFlush();
        return anuncio;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> list(){
        return Anuncio.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio find(@PathParam("id") Long id){
        return Anuncio.findById(id);
    }
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        System.out.println("entrou  path delet ");
        Anuncio.deleteById(id);
        System.out.println("EXECUTOU delet ");
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio update(@PathParam("id") Long id, 
                            @FormParam("desc") String desc){
        Anuncio anuncio = Anuncio.findById(id);
        if (desc != null) anuncio.setDescricao(desc);
        anuncio.persistAndFlush();
        return anuncio;                           
    }
}
