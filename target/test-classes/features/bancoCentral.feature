Feature: Prueba Banco Central

  Scenario: Validar información del sitio del Banco Central
    Given que abro el sitio del Banco Central
    When cuento las etiquetas H1 y P
    Then valido el título del sitio
    And muestro los valores de UF UTM Dolar y Euro
