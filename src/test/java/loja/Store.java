package loja;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Store {
    //Estrutura para ler o aquivo
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void venderPet() throws IOException {
       String jsonBody = lerJson("data/order.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) //transmitir
             .when()
                .post("https://petstore.swagger.io/v2/store/order")
            .then()
                .log().all()
                .statusCode(200)
                .body("id", is(5312))
                .body("petId", is(4211))
                .body("quantity", is(2))
                .body("status", is("placed"))
        ;
        System.out.print("Venda concluida com sucesso.");
    }

}
