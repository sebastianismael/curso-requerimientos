package edu.grupoesfera.modelo;

import java.util.List;

public class OrdenDeCompra {

    private List<ItemFactura> items;
    private String cliente;

    public OrdenDeCompra(){}

    public OrdenDeCompra(List<ItemFactura> items, String cliente) {
        this.items = items;
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
