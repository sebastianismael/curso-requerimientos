package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.grupoesfera.modelo.Compra;
import edu.grupoesfera.modelo.Factura;
import edu.grupoesfera.modelo.Item;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RealizarCompraSteps extends StepDefinition {

    private List<Item> items = new LinkedList<>();
    private Factura factura;

    @Given("^se agregan a la compra (.*) (.*) de \\$(.*)$")
    public void seAgreganALaCompraProductos(Integer cantidad, String producto, Double precio) {
        items.add(new Item(cantidad, producto, precio));
    }

    @When("^realiza la compra$")
    public void realizarLaCompra() {
        factura = restTemplate.postForObject(url() + "/comprar", new Compra(items, "cliente s.a."), Factura.class);
    }

    @Then("^se obtiene una factura por \\$(.*)$")
    public void seObtieneUnaFacturaPor(Double montoFactura) {
        assertThat(factura.getMonto()).isEqualTo(montoFactura);
    }

}
