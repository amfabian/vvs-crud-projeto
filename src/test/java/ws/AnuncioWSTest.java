package ws;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class AnuncioWSTest {
    
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
            .when().get("/anuncio/list")
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
    void testeAnuncioCreateEndpoint(){

     /*    PRECISA DE MOCK
            given().formParam("manga_id", "12")
                .formParam("user_id", "1")
                .formParam("desc", "Alguma coisa na descricao")
            .when().post("/anuncio/create")
            .then()
                .statusCode(200); */
    }

    @Test
    @Order(5)
    @DisplayName("Teste 5 = Post CREATE")
    void testeAnuncioCreateEndpointWithAssert(){

       /*  PRECISA DE MOCK
            given().formParam("manga_id", "12")
                .formParam("user_id", "1")
                .formParam("desc", "Alguma coisa na descricao")
            .when().post("/anuncio/create")
            .then()
                .statusCode(200)
                .assertThat().body(containsString("descricao")); */
    }

    @Test
    @Order(5)
    @DisplayName("Teste 6 = Post CREATE")
    void testeAnuncioListIDEndpoint(){

        given()
            .when().get("/anuncio/1")
            .then()
                .statusCode(404);
    }

}