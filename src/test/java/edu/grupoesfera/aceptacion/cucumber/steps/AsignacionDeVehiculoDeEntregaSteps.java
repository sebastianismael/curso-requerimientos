package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AsignacionDeVehiculoDeEntregaSteps extends StepDefinition {

    @Given("^Se realiza la compra de (.*) libros de (.*) kg cada uno$")
    public void seRealizaLaCompraDeLibrosDeKgCadaUno(Integer cantidadDeLibros, Integer pesoDeCadaLibro) {
    }

    @When("^se solicita la entrega en la calle (.*)$")
    public void seSolicitaLaEntregaEnLaCallePeru(String direccionDeEntrega) {
    }

    @Then("^se asigna como vehiculo de entrega (.*)$")
    public void seAsignaComoVehiculoDeEntregaUnaBicileta(String vehiculo) {
    }

}
