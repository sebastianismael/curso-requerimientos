package edu.grupoesfera.controladores;

import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Pedido;
import edu.grupoesfera.servicios.CalculadorDeCostoDeEntrega;
import edu.grupoesfera.servicios.GeneradorDeEnvios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBiblioteca {

    @PostMapping(path = "/calcular-costo-envio")
    public Integer calcularCosto(@RequestBody Pedido pedido){
        return CalculadorDeCostoDeEntrega.calcular(pedido.getProductos(), pedido.getTipoCliente());
    }

    @PostMapping(path = "/solicitar-entrega")
    public ResponseEntity<Envio> solicitarEntrega(@RequestBody Pedido pedido){
        try {
            return ResponseEntity.ok(GeneradorDeEnvios.generar(pedido.getProductos(), pedido.getDireccionDeEntrega()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
