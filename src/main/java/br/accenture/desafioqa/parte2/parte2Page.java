package br.accenture.desafioqa.parte2;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;

public class parte2Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public parte2Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void open(String url) {
        driver.get(url);

    }


    public void clickHeader() throws InterruptedException {
        Thread.sleep(8000);
        WebElement selecionarHeader = driver.findElement(By.xpath("//*[@id='app']/header"));
        selecionarHeader.click();
    }

    public void clickMenuForms() {
        // Espera o botão "Forms" estar visível antes de clicar

        WebElement selecionarBtnForms = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]"));
        selecionarBtnForms.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

    }

    public void clickSubmenuPracticeForm() throws InterruptedException {
        Thread.sleep(2000);
        WebElement selecionarBtnPraticeForms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Practice Form']")));
        selecionarBtnPraticeForms.click();
    }

    public void PreencherValoresFormulario() throws InterruptedException {
        // Preenchendo os campos com valores aleatórios
        Thread.sleep(2000);
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstName.sendKeys("NomeAleatório");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("SobrenomeAleatório");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("hebreu.teste@exemplo.com");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(200);
        actions.sendKeys(Keys.SPACE).perform();

        WebElement mobile = driver.findElement(By.id("userNumber"));
        mobile.sendKeys("1234567890");

        WebElement uploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadPicture")));
        String filePath = "D:\\ProjetoBaseDesafioQA\\desafio-qa-accenture\\src\\main\\resources\\testFile.txt";
        uploadButton.sendKeys(filePath);

    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    public void verifyPopupDisplayed() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        assert popup.isDisplayed() : "Popup não está visível.";
    }

    public void closePopup() throws InterruptedException {
        Thread.sleep(2000);
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='closeLargeModal']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeButton);
        closeButton.click();

        //WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='close']")));
        //closeButton.click();
    }


    public void clickMenuAlertsFrameWindows() throws InterruptedException {

        Thread.sleep(8000);
        WebElement selecionarBtnAlertsFrameWindows = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selecionarBtnAlertsFrameWindows);
        selecionarBtnAlertsFrameWindows.click();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
    }


    public void clickMenuBrowserWindows() throws InterruptedException {

        Thread.sleep(2000);
        WebElement selecionarBtnBrowserWindows = driver.findElement(By.xpath("//span[@class='text' and text()='Browser Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selecionarBtnBrowserWindows);
        selecionarBtnBrowserWindows.click();

    }

    public void clickBtnNewWindow() throws InterruptedException {

        Thread.sleep(2000);
        WebElement selecionarBtnNewWindow = driver.findElement(By.xpath("//*[@id='windowButton']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selecionarBtnNewWindow);
        selecionarBtnNewWindow.click();


    }

    public void validarTelaEMsg() throws InterruptedException {

        Thread.sleep(2000);
        String mainWindow = driver.getWindowHandle(); // Armazena o ID da janela principal
        Set<String> allWindows = driver.getWindowHandles();

        // Identificar a nova janela
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle); // Troca para a nova janela

                // Validação da mensagem
                WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
                String expectedMessage = "This is a sample page";
                if (message.getText().equals(expectedMessage)) {
                    System.out.println("Mensagem verificada com sucesso: " + expectedMessage);
                } else {
                    System.out.println("Mensagem não corresponde ao esperado.");
                }

                // Fechar a nova janela e voltar para a janela principal
                driver.close();
                driver.switchTo().window(mainWindow); // Retorna para a janela original
                break;

            }
        }
    }


}