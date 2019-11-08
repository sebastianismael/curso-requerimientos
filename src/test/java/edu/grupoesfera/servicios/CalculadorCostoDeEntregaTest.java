package edu.grupoesfera.servicios;

import org.junit.Test;

import java.util.HashMap;

public class CalculadorCostoDeEntregaTest {

    @Test(expected = RuntimeException.class)
    public void calcularCostoDeEntregaParaListaDeProductosVaciasLanzaError(){
        CalculadorDeCostoDeEntrega.calcular(new HashMap<>(), "");
    }
}
