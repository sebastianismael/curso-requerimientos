Feature: Asignación de vehiculo que realizará la entrega al envio.

La entrega se realizará en bicicleta en caso que el pedido no exceda los 5 paquetes.
La entrega se realizará en moto en caso que el pedido supere los 5 paquetes y no supere los 10 paquetes.
La entrega se realizará en auto en caso que el pedido sea superior a 10
No es posible asignar vehiculo para pedidos superiores a 30 paquetes.

  Scenario: A un pedido de menos de 5 paquetes se le asigna como vehiculo de entrega bicicleta
    Given Se realiza la compra de 5 libros
    When se solicita la entrega en la calle Peru 111
    Then se asigna como vehiculo de entrega Bicicleta

  Scenario: A un pedido de mas de 5 y menos de 10 paquetes se le asigna como vehiculo de entrega moto
    Given Se realiza la compra de 7 libros
    When se solicita la entrega en la calle Peru 111
    Then se asigna como vehiculo de entrega Moto

  Scenario: A un pedido de mas de 10 y menos de 30 paquetes se le asigna como vehiculo de entrega auto
    Given Se realiza la compra de 23 libros
    When se solicita la entrega en la calle Peru 111
    Then se asigna como vehiculo de entrega Auto