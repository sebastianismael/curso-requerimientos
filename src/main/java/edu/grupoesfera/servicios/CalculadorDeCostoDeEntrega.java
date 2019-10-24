package edu.grupoesfera.servicios;

import edu.grupoesfera.dto.Pedido;
import edu.grupoesfera.modelo.Entrega;

public class CalculadorDeCostoDeEntrega {

    private static final String VIP = "VIP";
    public static final String LIBROS = "libros";
    private static int MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA = 5;

    public static Integer calcular(Pedido pedido) {
        if(esClienteVIP(pedido)){
            if(hayCantidadSuficienteDeLibrosParaEntregaGratuitaEnEl(pedido)){
                if(haySoloUnProductoEnEl(pedido)){
                    return Entrega.GRATUITA.costo();
                }
            }
        }
        return Entrega.STANDARD.costo();
    }

    private static boolean haySoloUnProductoEnEl(Pedido pedido) {
        return pedido.getProductos().size() == 1;
    }

    private static boolean esClienteVIP(Pedido pedido) {
        return pedido.getTipoCliente().equalsIgnoreCase(VIP);
    }

    private static Boolean hayCantidadSuficienteDeLibrosParaEntregaGratuitaEnEl(Pedido pedido){
        if(pedido.getProductos().containsKey(LIBROS)){
            return pedido.getProductos().get(LIBROS) >= MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA;
        }
        return false;
    }

}
