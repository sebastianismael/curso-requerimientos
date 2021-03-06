package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Factura;
import edu.grupoesfera.modelo.Item;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class Facturador {

    public static final String LIBROS = "LIBROS";

    public Factura facturar(String cliente, List<Item> items) {
        Double monto = items.stream().mapToDouble(calcularCostoItem).sum();

        Factura factura = new Factura();
        factura.setMonto(monto);
        factura.setCliente(cliente);
        return factura;
    }

    private boolean elItemCorrespondeALibros(Item item) {
        return item.getProducto().equalsIgnoreCase(LIBROS);
    }

    private ToDoubleFunction<Item> calcularCostoItem = item -> {
        if(elItemCorrespondeALibros(item)){
            final int triadas = item.getCantidad() / 3;
            final int resto = item.getCantidad() % 3;
            return item.getPrecioUnitario() * 2 * triadas + item.getPrecioUnitario() * resto;
        } else {
            return item.getPrecioUnitario() * item.getCantidad();
        }

    };

}
