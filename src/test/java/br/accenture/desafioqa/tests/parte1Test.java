package br.accenture.desafioqa.tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/main/resources/features.desafioqa/parte1/CT001 - Validar criar usuario com sucesso.feature",
                "src/main/resources/features.desafioqa/parte1/CT002 - Validar criar usuario ja existente.feature",
                "src/main/resources/features.desafioqa/parte1/CT003 - Validar Gerar um token de acesso.feature",
                "src/main/resources/features.desafioqa/parte1/CT004 - Validar Gerar um token BadRequest 400.feature",
                "src/main/resources/features.desafioqa/parte1/CT005 - Validar Gerar um Token de acesso com usuario inexistente.feature",
                "src/main/resources/features.desafioqa/parte1/CT006 - Validar Confirmacao Autorizado.feature",
                "src/main/resources/features.desafioqa/parte1/CT007 - Validar Confirmacao Autorizacao de usuario inexistente.feature",
                "src/main/resources/features.desafioqa/parte1/CT008 - Validar Confirmacao Autorizacao 400BadRequest.feature",
                "src/main/resources/features.desafioqa/parte1/CT010 - Validar Alugar dois livros.feature",
                "src/main/resources/features.desafioqa/parte1/CT011 - Listar Detalhes do Usuário com Livros Escolhidos.feature",
        },

        glue = "br.accenture.desafioqa.parte1",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class parte1Test {

}
