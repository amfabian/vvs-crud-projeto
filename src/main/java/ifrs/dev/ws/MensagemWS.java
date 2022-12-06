package ifrs.dev.ws;

import java.util.List;
import java.util.logging.Logger;

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
import ifrs.dev.model.Mensagem;

@Path("/mensagem")
public class MensagemWS {
    private static final Logger LOGGER = Logger.getLogger(MensagemWS.class.getName()); 

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Mensagem create(@FormParam("anuncio_id") Long anuncio_id,
                            @FormParam("texto") String texto,
                            @FormParam("user_id") String user_id){
        Mensagem msg = new Mensagem();
        msg.setTexto(texto);
        msg.setUser_id(user_id);
        msg.persistAndFlush();

        Anuncio anuncio = Anuncio.findById(anuncio_id);
        if(anuncio == null)
            throw new BadRequestException("Anuncio not found");
        
        anuncio.addMensagem(msg);
        anuncio.persistAndFlush();
        LOGGER.info("CREATE Mensagem");
        return msg;                        
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mensagem> list(){
        return Mensagem.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensagem find(@PathParam("id") Long id){
        return Mensagem.findById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        LOGGER.info("DELETE Mensagem");
        Mensagem.deleteById(id);
    }
    //eh necessario ter um update?
    @PUT
    @Path("/update/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Mensagem update(@PathParam("id") Long id, 
                            @FormParam("texto") String texto){
        Mensagem mensagem = Mensagem.findById(id);
        if (texto != null) mensagem.setTexto(texto);
        mensagem.persistAndFlush();
        LOGGER.info("UPDATE Mensagem");
        return mensagem;                           
    }
}
