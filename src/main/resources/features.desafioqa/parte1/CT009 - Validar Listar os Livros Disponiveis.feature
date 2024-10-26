Feature: CT009 - Validar Listar os Livros Disponiveis
  Scenario: CT009 - Validar Listar os Livros Disponiveis
    Given eu envio uma requisição GET para Listar os livros disponiveis "https://demoqa.com/BookStore/v1/Books"
    Then a resposta deve ter o status 200