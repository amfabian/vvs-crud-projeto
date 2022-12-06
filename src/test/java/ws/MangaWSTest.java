package ws;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MangaWSTest {
    @Test
    @Order(1)
    @DisplayName("Teste 1 - teste que a página inicial do service está funcionando")
    void testHome(){

        given()
            .when().get()
            .then()
                .statusCode(200);
    }

    @Test
    @Order(2)
    @DisplayName("Teste 2 - teste Anuncio List")
    public void testeAnuncioListEndpoint(){

        given()
            .when().get("/manga/list")
            .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    @DisplayName("Teste 3 - Testa Path errado")
    void testErrorPath(){

        given()
            .when().get("/test")
            .then()
                .statusCode(404);
    }

    @Test
    @Order(4)
    @DisplayName("Teste 4 = Post CREATE")
    void testeAnuncioListIDEndpoint(){

        given()
            .when().get("/manga/1")
            .then()
                .statusCode(404);
    }
}
