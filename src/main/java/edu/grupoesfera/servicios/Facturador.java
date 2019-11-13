package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Factura;
import edu.grupoesfera.modelo.Item;

import java.util.List;

public class Facturador {
    public Factura facturar(String cliente, List<Item> items) {
        Factura factura = new Factura();
        Double monto = 0.0;
        for(Item item : items){
            if(item.getProducto().equalsIgnoreCase("LIBROS")){
                final int triadas = item.getCantidad() / 3;
                final int resto = item.getCantidad() % 3;
                monto = item.getPrecioUnitario() * 2 * triadas + item.getPrecioUnitario() * resto;
            } else {
                monto += item.getPrecioUnitario() * item.getCantidad();
            }
        }
        factura.setMonto(monto);
        return factura;
    }

}
