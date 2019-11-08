package edu.grupoesfera.modelo;

import java.util.Map;

public class Pedido {
    private String tipoCliente;
    private Map<String, Integer> productos;

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Map<String, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<String, Integer> productos) {
        this.productos = productos;
    }
}
