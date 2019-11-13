package edu.grupoesfera.modelo;

import java.util.List;

public class Compra {

    private List<Item> items;
    private String cliente;

    public Compra(){}

    public Compra(List<Item> items, String cliente) {
        this.items = items;
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
