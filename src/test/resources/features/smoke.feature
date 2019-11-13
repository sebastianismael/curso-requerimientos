Feature: Prueba de keep alive sobre el sitio

  Scenario: El sitio esta disponible
    Given
    When hago la prueba de conectividad con el sitio
    Then obtengo una respuesta exitosa

  @skip
  Scenario: Ejemplo de como marcar scenarios como pendientes, aparecen en el reporte de serenity como skiped
    Given
    When hago la prueba de conectividad con el sitio
    Then obtengo una respuesta exitosa

  @ignore
  Scenario: Ejemplo de como ignorar scenarios, no aparecen en el reporte de serenity
  Given
    When hago la prueba de conectividad con el sitio
    Then obtengo una respuesta exitosa

