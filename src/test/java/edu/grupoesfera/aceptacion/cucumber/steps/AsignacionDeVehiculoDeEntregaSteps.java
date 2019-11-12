package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AsignacionDeVehiculoDeEntregaSteps extends StepDefinition {

    private Map<String, Integer> productos = new HashMap<>();
    private Pedido pedido = new Pedido();
    private ResponseEntity<Envio> envio;

    @Given("^Se realiza la compra de (.*) (.*)$")
    public void seRealizaLaCompraDeProductos(Integer cantidad, String producto) {
        agregarAlPedido(producto, cantidad);
    }

    @When("^se solicita la entrega en la calle (.*)$")
    public void seSolicitaLaEntregaEnLaCalle(String direccionDeEntrega) {
        pedido.setDireccionDeEntrega(direccionDeEntrega);
        pedido.setProductos(productos);
        envio = restTemplate.postForEntity(url() + "/solicitar-entrega", pedido, Envio.class);
    }

    @Then("^se asigna como vehiculo de entrega (.*)$")
    public void seAsignaComoVehiculoDeEntrega(String vehiculo) {
        assertThat(envio.getBody().getVehiculo()).isEqualToIgnoringCase(vehiculo);
    }

    private void agregarAlPedido(String item, Integer cantidad) {
        productos.put(item, cantidad);
    }

    @Then("^no es posible asignar un vehiculo$")
    public void noEsPosibleAsignarUnVehiculo() {
        assertThat(envio.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
