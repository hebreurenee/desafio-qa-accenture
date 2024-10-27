package br.accenture.desafioqa.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {

                "src/main/resources/features.desafioqa.parte2/CT001 - Preencher e Submeter o Formulário de Prática.feature",
                "src/main/resources/features.desafioqa.parte2/CT002 - Abrir nova janela e validar mensagem This is a sample page.feature",
                "src/main/resources/features.desafioqa.parte2/CT003 - Realizar operações de CRUD na tabela do site DemoQA.feature",
                "src/main/resources/features.desafioqa.parte2/CT004 - Controlar o progresso e resetar a barra.feature",


        },
        glue = "br.accenture.desafioqa.parte2",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class parte2Test {

}
