package edu.grupoesfera.aceptacion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest extends PruebaDeAceptacion {

    @Test
    public void smoke() {
        final String json = this.restTemplate.getForObject(url + "/isAlive", String.class);
        assertThat(json).isEqualTo("=)");
    }

}
