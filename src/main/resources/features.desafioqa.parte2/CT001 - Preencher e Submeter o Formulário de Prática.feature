Feature: CT012 - Preencher e Submeter o Formulário de Prática
  Scenario: CT012 - Preencher e Submeter o Formulário de Prática com Valores Aleatórios
    Given que acesse o site "https://demoqa.com/"
    And escolha a opção Forms na página inicial
    And clique no submenu Practice Form
    And preencha todo o formulário com valores aleatórios
    When submeter o formulário
    Then popup deve ser exibido após o submit
    And fecho o popup