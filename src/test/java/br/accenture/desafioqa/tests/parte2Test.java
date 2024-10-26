package br.accenture.desafioqa.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/br/accenture/desafioqa/parte2",
        glue = "br.accenture.desafioqa.parte2",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class parte2Test {

}
