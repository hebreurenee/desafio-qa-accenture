Feature: CT013 - Abrir nova janela e validar mensagem This is a sample page

  Scenario: CT013 - Abrir nova janela e validar mensagem This is a sample page
    Given que acesse o site "https://demoqa.com/"
    And escolha a opção Alerts, Frame & Windows na página inicial
    And clique no submenu Browser Windows
    When clico no botão New Window
    Then uma nova janela deve ser aberta a mensagem This is a sample page deve estar visível na nova janela e fechar a nova janela
