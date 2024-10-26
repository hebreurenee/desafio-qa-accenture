Feature: CT001 - Validar criar usuario com sucesso
  Scenario: CT001 - Validar criar usuario com sucesso
    Given que eu tenha um payload válido para criação de usuário
    When eu envio uma requisição POST para "/Account/v1/User"
    Then a resposta deve ter o status 201
    And o campo userID deve estar presente
    And o campo username deve estar presente
    And o campo books deve estar presente