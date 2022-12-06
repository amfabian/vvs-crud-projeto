package ws;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.google.inject.Inject;

import ifrs.dev.model.Usuario;
import ifrs.dev.ws.UsuarioWS;

import static io.restassured.RestAssured.given;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import static org.mockito.Mockito.when;

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
    @Order(6)
    @DisplayName("Teste 6 = Post List")
    void testeUsuarioListIDEndpoint(){
       
        given()
            .when().get("/user/1")
            .then()
            .assertThat().body(containsString(""));
    }

    @Test
    @Order(6)
    @DisplayName("Teste 6 = Post List")
    void testeUsuarioListIDEndpoint2(){
       
        given()
            .when().get("/user/1")
            .then()
            .statusCode(404);
    }

    @Test
    @Order(7)
    @DisplayName("Teste 6 = Post List")
    void testeUsuarioListIDEndpoint3(){
       
        given()
            .when().get("/user/list/1")
            .then()
            .statusCode(404);
    }

   
    
}
