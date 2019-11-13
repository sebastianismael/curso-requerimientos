Feature: Compra de productos

La compra genera una factura para el cliente comprador con el importe total, el cliente.
En caso que se compren 3 libros se aplica una promocion 3 x 2 en el precio de los libros.
En caso que se compren 1 o 2 libros no se aplica la promocion.
Solo a los libros se le aplica la promoción 3 x 2.
Si se compran libros y otro producto la promoción corre unicamente para los libros.

  Scenario: Se realiza la compra de menos de 3 libros
    Given se agregan a la compra 2 libros de $40
    When realiza la compra
    Then se obtiene una factura por $80

  @skip
  Scenario: Se realiza la compra de 3 libros
    Given se agregan a la compra 3 libros de $40
    When realiza la compra
    Then se obtiene una factura por $80

  @skip
  Scenario: Se realiza la compra de 3 DVD
    Given se agregan a la compra 3 DVD de $30
    When realiza la compra
    Then se obtiene una factura por $90

  @skip
  Scenario: Se realiza la compra de menos de 3 libros y 3 DVD
    Given se agregan a la compra 3 libros de $40
    And se agregan a la compra 3 DVD de $30
    When realiza la compra
    Then se obtiene una factura por $170

