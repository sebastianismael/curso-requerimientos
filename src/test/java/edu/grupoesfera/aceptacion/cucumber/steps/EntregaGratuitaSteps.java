package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.sbe.aceptacion.cucumber.steps.StepDefinition;

public class EntregaGratuitaSteps extends StepDefinition {

    @Given("^el comprador es un cliente (.*)$")
    public void indicarTipoDeClienteQueRealizaElPedido(String tipoCliente) {

    }

    @When("^realiza la compra de (.*) (.*)$")
    public void agregarProductosAlPedido(Integer cantidad, String producto) {

    }

    @Then("^obtiene entrega (.*)$")
    public void validarGastosDeEntrega(String tipoDeEntrega) {

    }
    //{"tipoCliente":"VIP","productos":{"libros":5}}
}
