package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Factura;
import edu.grupoesfera.modelo.Item;

import java.util.List;

public class Facturador {
    public Factura facturar(String cliente, List<Item> items) {
        Factura factura = new Factura();
        factura.setMonto(80.0);
        return factura;
    }
}
