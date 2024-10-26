Feature: CT002 - Validar criar usuario ja existente
  Scenario: CT002 - Validar criar usuario ja existente
    Given que eu tenha um payload válido ja cadastrado para criação de usuário
    When eu envio uma requisição POST para "/Account/v1/User"
    Then a resposta deve ter o status 406
    And o campo code deve ter o valor "1204"
    And o campo message deve ter o valor "User exists!"
