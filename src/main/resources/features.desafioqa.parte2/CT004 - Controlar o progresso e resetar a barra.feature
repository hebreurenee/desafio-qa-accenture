Feature: CT004 - Controlar o progresso e resetar a barra.feature
  Scenario: CT004 - Controlar o progresso e resetar a barra.feature
    Given que acesse o site "https://demoqa.com/"
    When clique no menu Widgets
    And seleciona o submenu Progress Bar
    And clica no botão Start para iniciar a barra de progresso
    Then a barra de progresso deve atingir menos de 25%
    And o valor da barra de progresso deve ser menor ou igual a 25%
    When o usuário clica em Start novamente
    And a barra de progresso atinge 100%
    Then o usuário clica no botão Reset
    And a barra de progresso é resetada para 0%