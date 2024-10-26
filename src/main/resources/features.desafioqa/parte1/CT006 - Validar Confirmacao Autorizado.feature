Feature: CT006 - Validar Confirmacao Autorizado
  Scenario: CT006 - Validar Confirmacao Autorizado
    Given que eu tenha um payload com usuario valido para Confirmar sua Autorizacao
    When eu envio uma requisição POST para confirmar o token "/Account/v1/Authorized"
    Then a resposta deve ter o status 200
    And o request ter o valor true
