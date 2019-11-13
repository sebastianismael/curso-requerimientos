package edu.grupoesfera.controladores;

import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Pedido;
import edu.grupoesfera.servicios.GeneradorDeEnvios;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBibliotecaTest {
    @Test
    public void generarEnvioConCantidadExcesivaDePaquetesDeberiaRetornarBadRequest() {
        ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca();
        controladorBiblioteca.setGeneradorDeEnvios(generadorDeEnviosMockQueLanzaExceptionSiempre());

        final ResponseEntity<Envio> envioResponseEntity = controladorBiblioteca.solicitarEntrega(pedidoMock());

        assertThat(envioResponseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    private Pedido pedidoMock() {
        Pedido pedido = mock(Pedido.class);
        when(pedido.getProductos()).thenReturn(mock(Map.class));
        when(pedido.getDireccionDeEntrega()).thenReturn(anyString());
        return pedido;
    }

    private GeneradorDeEnvios generadorDeEnviosMockQueLanzaExceptionSiempre(){
        GeneradorDeEnvios generadorDeEnvios = mock(GeneradorDeEnvios.class);
        try {
            when(generadorDeEnvios.generar(anyMap(), anyString())).thenThrow(Exception.class);
        } catch (Exception e) {
        }
        return generadorDeEnvios;
    }
}
