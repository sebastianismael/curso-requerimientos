package edu.grupoesfera.modelo;

public class ItemFactura {

    private Integer cantidad;
    private String producto;
    private Double precioUnitario;

    public ItemFactura(){}

    public ItemFactura(Integer cantidad, String producto, Double precioUnitario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
