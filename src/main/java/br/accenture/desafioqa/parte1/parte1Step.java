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

    //Gerar token de acesso
    @Given("que eu tenha um payload válido para gerar um token de acesso")
    public void que_eu_tenha_um_payload_válido_para_gerar_um_token_de_acesso() {
        requestBody = parte1Page.Payloadjaexistente();
        System.out.println(requestBody);
    }

    @When("eu envio uma requisição POST para gerar token {string}")
    public void eu_envio_uma_requisição_post_para_gerar_token(String endpoint) {
        response = RestAssured
                .given()
                .contentType(contentType)
                .body(requestBody)
                .when()
                .post("https://demoqa.com" + endpoint);
    }

    @Then("o campo token deve estar presente")
    public void o_campo_token_deve_estar_presente() {
        response.then().body("token", notNullValue());
    }

    @Then("o campo expires deve estar presente")
    public void o_campo_expires_deve_estar_presente() {
        response.then().body("expires", notNullValue());
    }

    @Then("o campo status ter o valor {string}")
    public void o_campo_status_ter_o_valor(String status) {
        response.then().body("status", equalTo(status));
    }

    @Then("o campo result ter o valor {string}")
    public void o_campo_result_ter_o_valor(String result) {
        response.then().body("result", equalTo(result));
    }

    @Given("que eu tenha um payload sem usuario para gerar um token de acesso")
    public void que_eu_tenha_um_payload_sem_usuario_para_gerar_um_token_de_acesso() {
        requestBody = parte1Page.PayloadSemUser();
        System.out.println(requestBody);
    }

    @Then("o campo code ter o valor {string}")
    public void o_campo_code_ter_o_valor(String code) {
        response.then().body("code", equalTo(code));
    }

    @Then("o campo message ter o valor {string}")
    public void o_campo_message_ter_o_valor(String message) {
        response.then().body("message", equalTo(message));
    }

    @Given("que eu tenha um payload com usuario inexistente para gerar um token de acesso")
    public void que_eu_tenha_um_payload_com_usuario_inexistente_para_gerar_um_token_de_acesso() {
        requestBody = parte1Page.criarPayload(); // Usa o método para criar o payload
        System.out.println(requestBody);
    }

    @Then("o campo token ter o valor {string}")
    public void o_campo_token_ter_o_valor(String token) {
        response.then().body("token", equalTo(null));
    }

    @Then("o campo expires ter o valor {string}")
    public void o_campo_expires_ter_o_valor(String expires) {
        response.then().body("expires", equalTo(null));
    }

    //Confirmacao Autorizacao
    @Given("que eu tenha um payload com usuario valido para Confirmar sua Autorizacao")
    public void que_eu_tenha_um_payload_com_usuario_valido_para_confirmar_sua_autorizacao() {
        requestBody = parte1Page.Payloadjaexistente();
        System.out.println(requestBody);
    }

    @When("eu envio uma requisição POST para confirmar o token {string}")
    public void eu_envio_uma_requisição_post_para_confirmar_o_token(String endpoint) {
        response = RestAssured
                .given()
                .contentType(contentType)
                .body(requestBody)
                .when()
                .post("https://demoqa.com" + endpoint);
    }

    @Then("o request ter o valor true")
    public void o_request_ter_o_valor_true() {
        response.then().body(equalTo("true"));
    }

    @Given("que eu tenha um payload com usuario inexistente para Confirmar sua Autorizacao")
    public void que_eu_tenha_um_payload_com_usuario_inexistente_para_confirmar_sua_autorizacao() {
        requestBody = parte1Page.criarPayload(); // Usa o método para criar o payload
        System.out.println(requestBody);

    }

    @Given("que eu tenha um payload sem usuario valido para Confirmar sua Autorizacao")
    public void que_eu_tenha_um_payload_sem_usuario_valido_para_confirmar_sua_autorizacao() {
        requestBody = parte1Page.PayloadSemUser();
        System.out.println(requestBody);
    }
}


