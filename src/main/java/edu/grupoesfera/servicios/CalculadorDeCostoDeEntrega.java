package edu.grupoesfera.servicios;

import edu.grupoesfera.dto.Pedido;
import edu.grupoesfera.modelo.Entrega;

public class CalculadorDeCostoDeEntrega {
    public static Integer calcular(Pedido pedido) {
        if(pedido.getTipoCliente().equalsIgnoreCase("VIP")){
            return Entrega.GRATUITA.costo();
        }
        return Entrega.STANDARD.costo();
    }
}
