Feature: CT011 - Listar Detalhes do Usuário com Livros Escolhidos
  Scenario: CT011 - Listar Detalhes do Usuário com Livros Escolhidos
    Given que eu tenha um payload válido para criação de usuário para alugar livros
    When eu criar o usuário e gerar o token de autorização
    And eu enviar uma requisição POST para alugar dois livros com o token e o userId
    Then eu listar os detalhes do usuário com os livros escolhidos
    And a resposta deve ter o status 200