package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Vehiculo;

import java.util.Map;

public class GeneradorDeEnvios {

    public static Envio generar(Map<String, Integer> productos, String direccionDeEntrega) {
        Envio envio = new Envio();
        envio.setDireccionDeEntrega(direccionDeEntrega);
        int cantidadDeProductos = contarProductos(productos);
        if(cantidadDeProductos <= 5){
            envio.setVehiculo(Vehiculo.BICICLETA.name());
        }
        else if(cantidadDeProductos <= 10){
            envio.setVehiculo(Vehiculo.MOTO.name());
        }
        return envio;
    }

    private static int contarProductos(Map<String, Integer> productos) {
        int cantidad = 0;
        for(Integer i : productos.values()){
            cantidad += i;
        }
        return cantidad;
    }
}
