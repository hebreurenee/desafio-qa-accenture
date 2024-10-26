Feature: CT010 - Validar Alugar dois livros
  Scenario: CT010 - Validar Alugar dois livros
    Given que eu tenha um payload válido para criação de usuário para alugar livros
    When eu criar o usuário e gerar o token de autorização
    And eu enviar uma requisição POST para alugar dois livros com o token e o userId
    Then a resposta deve ter o status 201
