package br.accenture.desafioqa.parte2;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;

public class parte2Step {

    private WebDriver driver;
    private parte2Page page;

    //1
    @Given("que acesse o site {string}")
    public void que_eu_acesse_o_site(String url) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new parte2Page(driver);
        page.open(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

    }

    @Given("escolha a opção Forms na página inicial")
    public void eu_escolha_a_opcao_Forms_na_pagina_inicial() throws InterruptedException {

        page.clickHeader();
        page.clickMenuForms();

    }

    @Given("clique no submenu Practice Form")
    public void eu_clique_no_submenu_Pratice_Form() throws InterruptedException {
        page.clickSubmenuPracticeForm();
    }

    @Given("preencha todo o formulário com valores aleatórios")
    public void eu_preencha_todo_o_formulario_com_valores_aleatorios() throws InterruptedException {
        page.PreencherValoresFormulario();
    }

    @When("submeter o formulário")
    public void eu_submeter_o_formulario() {
        page.submitForm();
    }

    @Then("popup deve ser exibido após o submit")
    public void um_popup_deve_ser_exibido_apos_o_submit() {
        page.verifyPopupDisplayed();
    }

    @Then("fecho o popup")
    public void eu_fecho_o_popup() throws InterruptedException {
        page.closePopup();
    }
    //2
    @Given("escolha a opção Alerts, Frame & Windows na página inicial")
    public void escolha_a_opção_alerts_frame_windows_na_página_inicial() throws InterruptedException {

        page.clickMenuAlertsFrameWindows();

    }
    @Given("clique no submenu Browser Windows")
    public void clique_no_submenu() throws InterruptedException {

        page.clickMenuBrowserWindows();

    }
    @When("eu clico no botão New Window")
    public void eu_clico_no_botão() throws InterruptedException {

        page.clickBtnNewWindow();

    }
    @Then("uma nova janela deve ser aberta a mensagem This is a sample page deve estar visível na nova janela e fechar a nova janela")
    public void uma_nova_janela_deve_ser_aberta_validar_msg() throws InterruptedException {

        page.validarTelaEMsg();

    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }

    }
}