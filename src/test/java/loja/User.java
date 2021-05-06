
//Pacote
package loja;

//Bibliotecas
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class User {

    //Estrutura para ler o aquivo
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Create / Incluir / POST
    @Test
    public void incluirPet() throws IOException {
        // Ler o conteúdo do arquivo user.json
        String jsonBody = lerJson("data/user.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) //transmitir
        .when()
                .post("https://petstore.swagger.io/v2/user")
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is("5312"))
        ;
        System.out.print("Usuário inserido com sucesso.");
    }
    //Reach or Research / Consultar / Get
    @Test
    public void consultarUsuario(){
        String username = "MRLAVIOLA";

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get("https://petstore.swagger.io/v2/user/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(5312))
                .body("username", is("MRLAVIOLA"))
                .body("firstName", is("Marilia"))
                .body("lastName", is("Laviola"))
                .body("email", is("marilia.teste@teste.com"))
                .body("password", is("Teste##123"))
                .body("phone", is("(45)998822882"))
        ;
    }

    // Update / Alterar / Put
    @Test
    public void alterarUsuario() throws IOException {
        // Ler o conteúdo do arquivo userput.json
        String jsonBody = lerJson("data/userput.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put("https://petstore.swagger.io/v2/user")
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is("5312"))
        ;
    }
    //Delete / Excluir / Delete
    @Test
    public void excluirUsuario(){
        String username = "MRLAVIOLA";

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete("https://petstore.swagger.io/v2/user/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is(username))
        ;
    }


}
