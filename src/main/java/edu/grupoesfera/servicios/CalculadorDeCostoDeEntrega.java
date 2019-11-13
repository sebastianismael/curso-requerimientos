package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.TipoDeEntrega;

import java.util.Map;

public class CalculadorDeCostoDeEntrega {

    private static final String VIP = "VIP";
    private static final String LIBROS = "libros";
    private static final int MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA = 5;

    public Integer calcular(Map<String, Integer> productos, String cliente) {

        if(pedidoVacio(productos)){
            throw new RuntimeException("El pedido con contiene productos");
        }

        if(esClienteVIP(cliente)){
            if(hayCantidadSuficienteDeLibrosParaEntregaGratuitaEn(productos)){
                if(haySoloUnTipoDeProductoEn(productos)){
                    return TipoDeEntrega.GRATUITA.costo();
                }
            }
        }
        return TipoDeEntrega.STANDARD.costo();
    }

    private boolean pedidoVacio(Map<String, Integer> productos) {
        return productos.isEmpty();
    }

    private boolean haySoloUnTipoDeProductoEn(Map<String, Integer> productos) {
        return productos.size() == 1;
    }

    private boolean esClienteVIP(String cliente) {
        return cliente.equalsIgnoreCase(VIP);
    }

    private Boolean hayCantidadSuficienteDeLibrosParaEntregaGratuitaEn(Map<String, Integer> productos){
        if(productos.containsKey(LIBROS)){
            return productos.get(LIBROS) >= MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA;
        }
        return false;
    }

}
