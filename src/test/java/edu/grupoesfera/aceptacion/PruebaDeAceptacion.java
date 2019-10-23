package edu.grupoesfera.aceptacion;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class PruebaDeAceptacion {

    @LocalServerPort
    private int port;
    protected String url;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void init(){
        url = "http://localhost:" + port + "/biblioteca";
    }

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

//    /**
//     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
//     */
//    @Before
//    public void setUp() {
//        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
//    }
}
