package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Entrega;

import java.util.Map;

public class CalculadorDeCostoDeEntrega {

    private static final String VIP = "VIP";
    private static final String LIBROS = "libros";
    private static final int MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA = 5;

    public static Integer calcular(Map<String, Integer> productos, String cliente) {

        return -1;
    }

    private static boolean haySoloUnTipoDeProductoEn(Map<String, Integer> productos) {
        return productos.size() == 1;
    }

    private static boolean esClienteVIP(String cliente) {
        return cliente.equalsIgnoreCase(VIP);
    }

    private static Boolean hayCantidadSuficienteDeLibrosParaEntregaGratuitaEn(Map<String, Integer> productos){
        if(productos.containsKey(LIBROS)){
            return productos.get(LIBROS) >= MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA;
        }
        return false;
    }

}
