Feature: CT007 - Validar Confirmacao Autorizacao de usuario inexistente
  Scenario: CT007 - Validar Confirmacao Autorizacao de usuario inexistente
    Given que eu tenha um payload com usuario inexistente para Confirmar sua Autorizacao
    When eu envio uma requisição POST para confirmar o token "/Account/v1/Authorized"
    Then a resposta deve ter o status 404
    And o campo code ter o valor "1207"
    And o campo message ter o valor "User not found!"