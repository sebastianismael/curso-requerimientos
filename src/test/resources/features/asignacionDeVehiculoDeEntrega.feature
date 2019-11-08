Feature: Asignación de vehiculo que realizará la entrega al envio.

La entrega se realizará en bicicleta en caso que el pedido no exceda los 5kg.
La entrega se realizará en moto en caso que el pedido supere los 5kg y no supere los 15kg.
La entrega se realizará en auto en caso que el pedido sea superior a 15kg y menor a 50kg.
No es posible asignar vehiculo para pedidos superiores a 50kg.

  Scenario: A un pedido de menos de 5kg se le asigna como vehiculo de entrega bicicleta
    Given Se realiza la compra de 3 libros de 1 kg cada uno
    When se solicita la entrega en la calle Peru 111
    Then se asigna como vehiculo de entrega Bicileta

