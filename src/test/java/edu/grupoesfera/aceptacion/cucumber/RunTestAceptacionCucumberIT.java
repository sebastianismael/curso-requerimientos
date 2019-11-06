package edu.grupoesfera.aceptacion.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources", tags = "not @ignore")
public class RunTestAceptacionCucumberIT {

}
