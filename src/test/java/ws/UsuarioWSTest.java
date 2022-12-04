package ws;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.CoreMatchers.containsString;


@QuarkusTest
public class UsuarioWSTest {

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
    @DisplayName("Teste 2 - teste Usuario List")
    public void testeUsuarioListEndpoint(){

        given()
            .when().get("/usuario/list")
            .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    @DisplayName("Teste 3 - Testa Path errado")
    void testErrorPath(){

        given()
            .when().get("/user")
            .then()
                .statusCode(404);

    }

    @Test
    @Order(4)
    @DisplayName("Teste 4 = Post CREATE")
    void testeUsuarioCreateEndpoint(){

        given().formParam("login", "teste")
                .formParam("password", "1234")
                .formParam("email", "teste@mail.com")
            .when().post("/usuario/create")
            .then()
                .statusCode(200);
    }

    @Test
    @Order(5)
    @DisplayName("Teste 5 = Post CREATE")
    void testeUsuarioCreateEndpointWithAssert(){

        given().formParam("login", "teste")
                .formParam("password", "1234")
                .formParam("email", "teste@mail.com")
            .when().post("/usuario/create")
            .then()
                .statusCode(200)
                .assertThat().body(containsString("teste@mail.com"));
    }

    @Test
    @Order(5)
    @DisplayName("Teste 6 = Post CREATE")
    void testeUsuarioListIDEndpoint(){

        given()
            .when().get("/user/1")
            .then()
                .statusCode(404);
    }

    
}
