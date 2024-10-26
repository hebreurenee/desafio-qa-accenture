Feature: CT003 - Validar Gerar um token de acesso
  Scenario: CT003 - Validar Gerar um token de acesso
    Given que eu tenha um payload válido para gerar um token de acesso
    When eu envio uma requisição POST para gerar token "/Account/v1/GenerateToken"
    Then a resposta deve ter o status 200
    And o campo token deve estar presente
    And o campo expires deve estar presente
    And o campo status ter o valor "Success"
    And o campo result ter o valor "User authorized successfully."