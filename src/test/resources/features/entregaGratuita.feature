Feature: La entrega gratuita se ofrece a clientes VIP cuando solicitan cierto numero de libros.
  La entrega gratuita no se ofrece a clientes regulares o a clientes VIP que compren otros items que no sean libros.
  El numero minimo de libros para obtener entrega gratuita es 5

  Scenario: Un cliente VIP pidiendo 5 libros obtiene entrega gratuita
    Given el comprador es un cliente VIP
    When realiza la compra de 5 libros
    Then obtiene entrega gratuita

#  Scenario: Un cliente VIP pidiendo 4 libros obtiene entrega standard
#    Given el comprador es un cliente VIP
#    When realiza la compra de 4 libros
#    Then obtiene entrega standard
#
#  Scenario: Un cliente Regular pidiendo 10 libros obtiene entrega standard
#    Given el comprador es un cliente Regular
#    When realiza la compra de 10 libros
#    Then obtiene entrega standard
#
#  Scenario: Un cliente VIP pidiendo 5 DVD obtiene entrega standard
#    Given el comprador es un cliente VIP
#    When realiza la compra de 5 DVD
#    Then obtiene entrega standard
#
#  Scenario: Un cliente VIP pidiendo 5 libros y 1 DVD obtiene entrega standard
#    Given el comprador es un cliente VIP
#    When realiza la compra de 5 libros
#    And realiza la compra de 1 DVD
#    Then obtiene entrega standard
