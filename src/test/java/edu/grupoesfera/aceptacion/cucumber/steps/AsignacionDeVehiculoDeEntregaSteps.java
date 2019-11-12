package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Pedido;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AsignacionDeVehiculoDeEntregaSteps extends StepDefinition {

    private Map<String, Integer> productos = new HashMap<>();
    private Pedido pedido = new Pedido();
    private Envio envio;

    @Given("^Se realiza la compra de (.*) (.*)$")
    public void seRealizaLaCompraDeProductos(Integer cantidad, String producto) {
        agregarAlPedido(producto, cantidad);
    }

    @When("^se solicita la entrega en la calle (.*)$")
    public void seSolicitaLaEntregaEnLaCalle(String direccionDeEntrega) {
        pedido.setDireccionDeEntrega(direccionDeEntrega);
        pedido.setProductos(productos);
        envio = restTemplate.postForObject(url() + "/solicitar-entrega", pedido, Envio.class);
    }

    @Then("^se asigna como vehiculo de entrega (.*)$")
    public void seAsignaComoVehiculoDeEntrega(String vehiculo) {
        assertThat(envio.getVehiculo()).isEqualToIgnoringCase(vehiculo);
    }

    private void agregarAlPedido(String item, Integer cantidad) {
        productos.put(item, cantidad);
    }

}
