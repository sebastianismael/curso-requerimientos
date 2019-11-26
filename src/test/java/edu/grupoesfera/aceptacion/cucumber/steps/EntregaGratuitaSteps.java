package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.grupoesfera.dto.Pedido;
import edu.grupoesfera.modelo.Entrega;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EntregaGratuitaSteps extends StepDefinition {

    private String tipoDeCliente;
    private Map<String, Integer> productos = new HashMap<>();
    private Pedido pedido = new Pedido();

    @Given("^el comprador es un cliente (.*)$")
    public void indicarTipoDeClienteQueRealizaElPedido(String tipoCliente) {
        this.tipoDeCliente = tipoCliente;
    }

    @When("^realiza la compra de (.*) (.*)$")
    public void agregarProductosAlPedido(Integer cantidad, String producto) {
        productos.put(producto, cantidad);
    }

    @Then("^obtiene entrega (.*)$")
    public void validarGastosDeEntrega(String tipoEntrega) {
        Integer gastosDeEnvio = 0;

        assertThat(gastosDeEnvio).isEqualTo(Entrega.costoDe(tipoEntrega));
    }


    //Integer gastosDeEnvio = restTemplate.postForObject(url() + "/calcular-costo-envio", pedido, Integer.class);
}
