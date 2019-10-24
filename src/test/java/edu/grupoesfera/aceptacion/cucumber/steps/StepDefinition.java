package edu.grupoesfera.aceptacion.cucumber.steps;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

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

    /**
     * Permite obtener como respuesta de un get un List tipado
     * @param uri path del servicio
     * @param responseType un wrapper de una lista parametrizada
     * @param <T> el tipo de datos de los objetos de la lista resultado
     * @return Una lista de objetos del tipo T
     */
    protected <T> List<T> getForObject(String uri, ParameterizedTypeReference<List<T>> responseType) {
        return restTemplate.exchange(uri, HttpMethod.GET, null, responseType).getBody();
    }
}
