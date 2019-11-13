package edu.grupoesfera.aceptacion.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class SmokeSteps extends StepDefinition {

    private String json;

    @When("^hago la prueba de conectividad con el sitio$")
    public void invocarSmoke(){
        json = this.restTemplate.getForObject(url() + "/isAlive", String.class);
    }

    @Then("^obtengo una respuesta exitosa$")
    public void respuestaExitosa() {
        assertThat(json).isEqualTo("=)");
    }

}
