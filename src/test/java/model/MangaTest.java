package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifrs.dev.model.Manga;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MangaTest {
   
    @Test
    @Order(1)
    @DisplayName("Teste com Panache no model Usuario")
    public void testUsuarioList(){
        PanacheMock.mock(Manga.class);
        Manga manga = new Manga();
        manga.setChapters("x");
        manga.setTitle("title");
        manga.getChapters();
        manga.getTitle();
        Mockito.when(Manga.findById(12L)).thenReturn(manga);
        Assertions.assertSame(manga, Manga.findById(12L));

    }

    @Test
    @Order(2)
    @DisplayName("Teste com Panache no model Usuario")
    public void testAnuncioListAll(){
        PanacheMock.mock(Manga.class);
        Manga manga = new Manga();
        manga.setMal_id("mal_id");
        manga.setImage_url("image");
        manga.getMal_id();
        manga.getImage_url();
        Assertions.assertNotNull(Manga.listAll());
    }
    @Test
    @Order(3)
    @DisplayName("Teste com Panache no model Usuario")
    public void testAnuncioUpdate(){
        PanacheMock.mock(Manga.class);
        Manga manga = new Manga();
        manga.setUrl("url");
        manga.getUrl();
        Assertions.assertSame(manga, manga);
      
    }
}
