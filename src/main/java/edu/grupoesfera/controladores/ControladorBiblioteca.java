package edu.grupoesfera.controladores;

import edu.grupoesfera.modelo.Pedido;
import edu.grupoesfera.servicios.CalculadorDeCostoDeEntrega;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBiblioteca {

    @PostMapping(path = "/calcular-costo-envio")
    public Integer calcularCosto(@RequestBody Pedido pedido){
        return CalculadorDeCostoDeEntrega.calcular(pedido.getProductos(), pedido.getTipoCliente());
    }
}
