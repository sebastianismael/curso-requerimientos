package edu.grupoesfera.servicios;

import edu.grupoesfera.dto.Pedido;
import edu.grupoesfera.modelo.Entrega;

public class CalculadorDeCostoDeEntrega {

    private static final String VIP = "VIP";
    private static int MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA = 5;

    public static Integer calcular(Pedido pedido) {
        if(esClienteVIP(pedido)){
            if(hayCantidadSuficienteDeLibrosParaEntregaGratuita(pedido)){
                return Entrega.GRATUITA.costo();
            }
        }
        return Entrega.STANDARD.costo();
    }

    private static boolean esClienteVIP(Pedido pedido) {
        return pedido.getTipoCliente().equalsIgnoreCase(VIP);
    }

    private static Boolean hayCantidadSuficienteDeLibrosParaEntregaGratuita(Pedido pedido){
        if(pedido.getProductos().containsKey("libros")){
            return pedido.getProductos().get("libros") >= MINIMA_CANTIDAD_LIBROS_PARA_ENTREGA_GRATUITA;
        }
        return false;
    }

}
