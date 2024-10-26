package br.accenture.desafioqa.tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/main/resources/features.desafioqa/parte1/CT002 - Validar criar usuario ja existente.feature",
        },
        glue = "br.accenture.desafioqa.parte1",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class parte1Test {

}
