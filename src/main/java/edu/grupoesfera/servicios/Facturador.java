package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Factura;
import edu.grupoesfera.modelo.Item;

import java.util.List;

public class Facturador {
    public Factura facturar(String cliente, List<Item> items) {
        Factura factura = new Factura();
        Double monto = 0.0;
        for(Item item : items){
            monto += item.getPrecioUnitario() * item.getCantidad();
        }
        factura.setMonto(monto);
        return factura;
    }
}
