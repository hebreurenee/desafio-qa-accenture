Feature: CT005 - Validar Gerar um Token de acesso com usuario inexistente
  Scenario: CT005 - Validar Gerar um Token de acesso com usuario inexistente
    Given que eu tenha um payload com usuario inexistente para gerar um token de acesso
    When eu envio uma requisição POST para gerar token "/Account/v1/GenerateToken"
    Then a resposta deve ter o status 200
    And o campo token ter o valor "null"
    And o campo expires ter o valor "null"
    And o campo status ter o valor "Failed"
    And o campo result ter o valor "User authorization failed."