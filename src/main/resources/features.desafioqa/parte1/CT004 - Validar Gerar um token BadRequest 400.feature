Feature: CT004 - Validar Gerar um token BadRequest 400
  Scenario: CT004 - Validar Gerar um token BadRequest 400
    Given que eu tenha um payload sem usuario para gerar um token de acesso
    When eu envio uma requisição POST para gerar token "/Account/v1/GenerateToken"
    Then a resposta deve ter o status 400
    And o campo code ter o valor "1200"
    And o campo message ter o valor "UserName and Password required."