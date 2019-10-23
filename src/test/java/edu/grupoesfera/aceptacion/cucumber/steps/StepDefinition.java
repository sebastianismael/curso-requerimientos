package edu.grupoesfera.aceptacion.cucumber.steps;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@Ignore @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StepDefinition {

    @LocalServerPort
    private int port;
    private String url;

    protected String url() {
        return url = "http://localhost:" + port + "/biblioteca";
    }

    @Autowired
    protected TestRestTemplate restTemplate;
}
