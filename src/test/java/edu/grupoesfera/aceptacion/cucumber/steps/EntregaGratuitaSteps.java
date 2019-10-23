package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EntregaGratuitaSteps {
    @Given("^el comprador es un cliente (.*)$")
    public void elCompradorEsUnCliente(String tipoCliente) {
    }

    @When("^realiza la compra de (.*) (.*)$")
    public void realizaLaCompraDeLibros(Integer cantidad, String item) {
    }

    @Then("^obtiene entrega (.*)$")
    public void obtieneEntrega(String tipoEntrega) {
    }

}
