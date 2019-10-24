package edu.grupoesfera.servicios;

import edu.grupoesfera.dto.Pedido;

public class CalculadorDeCostoDeEntrega {
    public static Integer calcular(Pedido pedido) {
        if(pedido.getTipoCliente().equalsIgnoreCase("VIP")){
            return Integer.valueOf(0);
        }
        return Integer.valueOf(100);
    }
}
