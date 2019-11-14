Feature: Asignación de vehiculo que realizará la entrega al envio.

  Como departamento de logística
  Quiero que la asignación de vehículos para la entrega dependa de la cantidad de productos a entregar
  Para optimizar la logística y no tener los vehículos con más capacidad entregando pocos productos ni tener vehículos sobre exigidos


  La entrega se realizará en bicicleta en caso que el pedido no exceda los 5 paquetes.
  La entrega se realizará en moto en caso que el pedido supere los 5 paquetes y no supere los 10 paquetes.
  La entrega se realizará en auto en caso que el pedido sea superior a 10
  No es posible asignar vehiculo para pedidos superiores a 30 paquetes.

#  Scenario:
#    Given
#    And
#    When
#    And
#    Then
#    And
