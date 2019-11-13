package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.PedidoDeEnvio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AsignacionDeVehiculoDeEntregaSteps extends StepDefinition {

    private Map<String, Integer> productos = new HashMap<>();
    private PedidoDeEnvio pedido = new PedidoDeEnvio();
    private Envio envio;
    private HttpStatus httpStatus;

    @Given("^Se realiza la compra de (.*) (.*)$")
    public void seRealizaLaCompraDeProductos(Integer cantidad, String producto) {
        agregarAlPedido(producto, cantidad);
    }

    @When("^se solicita la entrega en la calle (.*)$")
    public void seSolicitaLaEntregaEnLaCalle(String direccionDeEntrega) {
        solicitarEnvioA(direccionDeEntrega);
    }

    @Then("^se asigna como vehiculo de entrega (.*)$")
    public void seAsignaComoVehiculoDeEntrega(String vehiculoAsignado) {
        validarQueElVehiculoDeEntregaSeaUn(vehiculoAsignado);
    }

    @Then("^no es posible asignar un vehiculo$")
    public void noEsPosibleAsignarUnVehiculo() {
        validarStatusDeLaRespuestaConError();
    }



    private void solicitarEnvioA(String direccionDeEntrega) {
        pedido.setDireccionDeEntrega(direccionDeEntrega);
        pedido.setProductos(productos);
        final ResponseEntity<Envio> responseEntity = restTemplate.postForEntity(url() + "/solicitar-entrega", pedido, Envio.class);
        envio = responseEntity.getBody();
        httpStatus = responseEntity.getStatusCode();
    }

    private void validarStatusDeLaRespuestaConError() {
        assertThat(httpStatus).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    private void validarQueElVehiculoDeEntregaSeaUn(String vehiculo) {
        assertThat(envio.getVehiculo()).isEqualToIgnoringCase(vehiculo);
    }

    private void agregarAlPedido(String item, Integer cantidad) {
        productos.put(item, cantidad);
    }
}
