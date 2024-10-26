package br.accenture.desafioqa.tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/main/resources/features.desafioqa/parte1/CT009 - Validar Listar os Livros Disponiveis.feature",
        },
        glue = "br.accenture.desafioqa.parte1",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class parte1Test {

}
