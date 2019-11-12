package edu.grupoesfera.servicios;

import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Vehiculo;

import java.util.Map;

public class GeneradorDeEnvios {

    public static Envio generar(Map<String, Integer> productos, String direccionDeEntrega) {
        Envio envio = new Envio();
        envio.setDireccionDeEntrega(direccionDeEntrega);
        if(productos.size() <= 5){
            envio.setVehiculo(Vehiculo.BICICLETA.name());
        }
        return envio;
    }
}
