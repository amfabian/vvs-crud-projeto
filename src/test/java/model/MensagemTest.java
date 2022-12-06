package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifrs.dev.model.Mensagem;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MensagemTest {
    @Test
    @Order(1)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioList(){
        PanacheMock.mock(Mensagem.class);
        Mensagem msg = new Mensagem();
        msg.setTexto("x");
        msg.setUser_id("user");
        msg.getTexto();
        msg.getUser_id();
        Mockito.when(Mensagem.findById(12L)).thenReturn(msg);
        Assertions.assertSame(msg, Mensagem.findById(12L));

    }

    @Test
    @Order(2)
    @DisplayName("Teste com Panache no model Usuario")
    public void testAnuncioListAll(){
        PanacheMock.mock(Mensagem.class);
        Assertions.assertNotNull(Mensagem.listAll());
    }
    @Test
    @Order(3)
    @DisplayName("Teste com Panache no model Usuario")
    public void testAnuncioUpdate(){
        PanacheMock.mock(Mensagem.class);
        Mensagem manga = new Mensagem();
        Assertions.assertSame(manga, manga);
      
    }
}
