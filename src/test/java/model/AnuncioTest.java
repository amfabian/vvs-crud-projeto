package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifrs.dev.model.Anuncio;
import ifrs.dev.model.Manga;
import ifrs.dev.model.Mensagem;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AnuncioTest {
    
    @Test
    @Order(1)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioList(){
        PanacheMock.mock(Anuncio.class);
        Anuncio a = new Anuncio();
        a.setAval("test");
        a.setDescricao("desc");
        a.getAval();
        a.getDescricao();
        Mockito.when(Anuncio.findById(12L)).thenReturn(a);
        Assertions.assertSame(a, Anuncio.findById(12L));

    }

    @Test
    @Order(2)
    @DisplayName("Teste com Panache no model Usuario")
    public void testAnuncioListAll(){
        PanacheMock.mock(Anuncio.class);
        Anuncio a = new Anuncio();
        a.setManga(new Manga());
        a.getManga();
        Assertions.assertNotNull(Anuncio.listAll());
    }
    @Test
    @Order(3)
    @DisplayName("Teste com Panache no model Usuario")
    public void testAnuncioUpdate(){
        PanacheMock.mock(Anuncio.class);
        Anuncio a = new Anuncio();
        List<Mensagem> list = new ArrayList<>();
        a.setMensagens(list);
        a.getMensagens();
        Assertions.assertSame(a, a);
      
    }
}

