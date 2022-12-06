package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifrs.dev.model.Anuncio;
import ifrs.dev.model.Usuario;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {

    @Test
    @Order(1)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioList(){
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();
        Mockito.when(Usuario.findById(12L)).thenReturn(u);
        Assertions.assertSame(u, Usuario.findById(12L));

    }

    @Test
    @Order(2)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioListNull(){
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();
        Mockito.when(Usuario.findById(12L)).thenReturn(u);
        Assertions.assertNull(Usuario.findById(42L));


    }

    @Test
    @Order(3)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioListAll(){
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();
        List<Usuario> list = new ArrayList<>();
        list.add(u);
        list.add(u);
        Assertions.assertNotNull(Usuario.listAll());
    }

    @Test
    @Order(4)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioDelete(){
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();
        Assertions.assertEquals(false, Usuario.deleteById(2L));
    }

    @Test
    @Order(5)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioUpdate(){
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();
        u.setAdmin(false);
        Anuncio anuncio = new Anuncio();
        List<Anuncio> list = new ArrayList<>();
       // list.add(anuncio);
        //u.addAnuncios(anuncio);
        u.setAnuncios(list);
        Assertions.assertSame(u, u);
      
    }

    
}
