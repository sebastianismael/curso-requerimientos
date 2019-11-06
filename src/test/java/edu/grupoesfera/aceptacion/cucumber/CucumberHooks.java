package edu.grupoesfera.aceptacion.cucumber;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.junit.Assume;

public class CucumberHooks {
    @Before("@skip")
    public void skip_scenario(Scenario scenario){
        Assume.assumeTrue(false);
    }
}