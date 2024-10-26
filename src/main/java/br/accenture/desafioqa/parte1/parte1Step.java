package br.accenture.desafioqa.parte1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class parte1Step {

    private String requestBody;
    private String contentType = "application/json";
    private Response response;

    @Given("que eu tenha um payload válido para criação de usuário")
    public void que_eu_tenha_um_payload_válido_para_criação_de_usuário() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("eu envio uma requisição POST para {string}")
    public void eu_envio_uma_requisição_post_para(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("a resposta deve ter o status {int}")
    public void a_resposta_deve_ter_o_status(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("o campo {string} deve estar presente")
    public void o_campo_deve_estar_presente(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("o campo {string} deve ser {string}")
    public void o_campo_deve_ser(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
