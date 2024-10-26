Feature: CT008 - Validar Confirmacao Autorizacao 400BadRequest
  Scenario: CT008 - Validar Confirmacao Autorizacao 400BadRequest
    Given que eu tenha um payload sem usuario valido para Confirmar sua Autorizacao
    When eu envio uma requisição POST para confirmar o token "/Account/v1/Authorized"
    Then a resposta deve ter o status 400
    And o campo code ter o valor "1200"
    And o campo message ter o valor "UserName and Password required."