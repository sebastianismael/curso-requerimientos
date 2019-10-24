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
    private Integer gastosDeEnvio;
    private Pedido pedido = new Pedido();

    @Given("^el comprador es un cliente (.*)$")
    public void elCompradorEsUnCliente(String tipoCliente) {
        this.tipoDeCliente = tipoCliente;
    }

    @When("^realiza la compra de (.*) (.*)$")
    public void realizaLaCompraDeLibros(Integer cantidad, String item) {
        productos.put(item, cantidad);
    }

    @Then("^obtiene entrega (.*)$")
    public void obtieneEntrega(String tipoEntrega) {
        validarQueGastosDeEnvioCorrespondanA(tipoEntrega);
    }



    private void validarQueGastosDeEnvioCorrespondanA(String tipoEntrega) {
        gastosDeEnvio = calcularGastosDeEnvio();
        assertThat(gastosDeEnvio).isEqualTo(Entrega.valueOf(tipoEntrega.toUpperCase()).costo());
    }

    private Integer calcularGastosDeEnvio() {
        pedido.setProductos(productos);
        pedido.setTipoCliente(tipoDeCliente);
        return restTemplate.postForObject(url() + "/calcular-costo-envio", pedido, Integer.class);
    }


}
