package br.accenture.desafioqa.parte1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class parte1Step {

    private String requestBody;
    private String contentType = "application/json";
    private Response response;

    private parte1Page parte1Page = new parte1Page();

    @Given("que eu tenha um payload válido para criação de usuário")
    public void que_eu_tenha_um_payload_valido_para_criacao_de_usuario() {
        requestBody = parte1Page.criarPayload(); // Usa o método para criar o payload
        System.out.println(requestBody);
    }

    @When("eu envio uma requisição POST para {string}")
    public void eu_envio_uma_requisicao_post_para(String endpoint) {
        response = RestAssured
                .given()
                .contentType(contentType)
                .body(requestBody)
                .when()
                .post("https://demoqa.com" + endpoint);
    }

    @Then("a resposta deve ter o status {int}")
    public void a_resposta_deve_ter_o_status(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("o campo userID deve estar presente")
    public void o_campo_userId_deve_estar_presente() {
        response.then().body("userID", notNullValue());
    }

    @Then("o campo username deve estar presente")
    public void o_campo_username_deve_estara_presente() {
        response.then().body("username", notNullValue());
    }

    @Then("o campo books deve estar presente")
    public void o_campo_books_deve_estara_presente() {
        response.then().body("books", notNullValue());
    }

    @Given("que eu tenha um payload válido ja cadastrado para criação de usuário")
    public void que_eu_tenha_um_payload_válido_ja_cadastrado_para_criação_de_usuário() {
        requestBody = parte1Page.Payloadjaexistente();
        System.out.println(requestBody);
    }
    @Then("o campo code deve ter o valor {string}")
    public void o_campo_code_deve_ter_o_valor(String expectedCode) {
        response.then().body("code", equalTo(expectedCode));
    }
    @Then("o campo message deve ter o valor {string}")
    public void o_campo_message_deve_estar_presente(String expectedMessage) {
        response.then().body("message", equalTo(expectedMessage));
    }

}


