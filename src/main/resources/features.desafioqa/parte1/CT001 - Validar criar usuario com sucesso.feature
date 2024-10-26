Feature: CT001 - Validar criar usuario com sucesso
  Scenario: CT001 - Validar criar usuario com sucesso
    Given que eu tenha um payload válido para criação de usuário
    When eu envio uma requisição POST para "/Account/v1/User"
    Then a resposta deve ter o status 201
    And o campo "userId" deve estar presente
    And o campo "username" deve ser "exemplo_usuario"
    And o campo "books" deve estar presente