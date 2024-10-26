package br.accenture.desafioqa.parte1;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class parte1Step {
    private String userId;
    private String token;
    private String requestBody;
    private String contentType = "application/json";
    private Response response;

    private parte1Page parte1Page = new parte1Page();

    @Before
    public void setUp() {
        // Limpa os valores antes de cada teste
        userId = null;
        token = null;
        requestBody = null;
    }

    @Given("que eu tenha um payload válido para criação de usuário")
    public void que_eu_tenha_um_payload_valido_para_criacao_de_usuario() {
        requestBody = parte1Page.criarPayload(); // Usa o método para criar o payload
        System.out.println(requestBody);
    }

    @When("eu envio uma requisição POST para {string}")
    public void eu_envio_uma_requisicao_post_para(String endpoint) {
        response = given()
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
        response = given()
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
        response = given()
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

    //Listar Livros Disponiveis
    @Given("eu envio uma requisição GET para Listar os livros disponiveis {string}")
    public void eu_envio_uma_requisicao_get_para_listar_os_livros_disponiveis(String url) {
        response = given()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    // Criação do usuário para alugar livros
    @Given("que eu tenha um payload válido para criação de usuário para alugar livros")
    public void que_eu_tenha_um_payload_válido_para_criação_de_usuário_para_alugar_livros() {
        requestBody = parte1Page.criarPayload(); // Usa o método para criar o payload
        System.out.println(requestBody);

        String url = "https://demoqa.com/Account/v1/User";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .statusCode(201) // Valida se a criação foi bem-sucedida
                .extract()
                .response();

        userId = response.jsonPath().getString("userID");
    }

    // Geração do token de autorização
    @When("eu criar o usuário e gerar o token de autorização")
    public void eu_criar_o_usuário_e_gerar_o_token_de_autorização() {
        String url = "https://demoqa.com/Account/v1/GenerateToken";

        Response response = given()
                .contentType("application/json")
                .body(requestBody) // Reutiliza o requestBody gerado anteriormente
                .when()
                .post(url)
                .then()
                .statusCode(200) // Valida se o token foi gerado com sucesso
                .extract()
                .response();

        token = response.jsonPath().getString("token");
    }

    // Requisição para alugar dois livros
    @When("eu enviar uma requisição POST para alugar dois livros com o token e o userId")
    public void eu_enviar_uma_requisição_post_para_alugar_dois_livros_com_o_token_e_o_user_id() {
        String url = "https://demoqa.com/BookStore/v1/Books";
        String requestBody = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\"isbn\": \"9781449365035\"},\n" +
                "    {\"isbn\": \"9781491950296\"}\n" +
                "  ]\n" +
                "}";

        response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .statusCode(201)
                .extract()
                .response();
    }

    //Listar Detalhes do Usuário com Livros Escolhidos
    @Then("eu listar os detalhes do usuário com os livros escolhidos")
    public void eu_listar_os_detalhes_do_usuário_com_os_livros_escolhidos() {
        String url = "https://demoqa.com/Account/v1/User/" + userId; // Endpoint para listar detalhes do usuário

        response = given()
                .header("Authorization", "Bearer " + token) // Adiciona o token se necessário
                .when()
                .get(url)
                .then()
                .extract()
                .response();

        System.out.println("Detalhes do usuário: " + response.getBody().asString());
        // Adicione asserções conforme necessário, por exemplo:
        response.then().statusCode(200);

    }
}


