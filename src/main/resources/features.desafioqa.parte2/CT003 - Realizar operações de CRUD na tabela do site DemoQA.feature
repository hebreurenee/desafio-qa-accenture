Feature: CT013 - Realizar operações de CRUD na tabela do site DemoQA
  Scenario: CT013 - Realizar operações de CRUD na tabela do site DemoQA
    Given que acesse o site "https://demoqa.com/"
    And escolha a opção Elements na página inicial
    And clique no submenu Web Tables
    When crio um novo registro
    And edito o novo registro criado
    Then deleto o novo registro criado