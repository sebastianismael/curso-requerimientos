package edu.grupoesfera.controladores;

import edu.grupoesfera.modelo.OrdenDeCompra;
import edu.grupoesfera.modelo.Envio;
import edu.grupoesfera.modelo.Factura;
import edu.grupoesfera.modelo.PedidoDeEnvio;
import edu.grupoesfera.servicios.CalculadorDeCostoDeEntrega;
import edu.grupoesfera.servicios.Facturador;
import edu.grupoesfera.servicios.GeneradorDeEnvios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBiblioteca {

    private Facturador facturador = new Facturador();
    private CalculadorDeCostoDeEntrega calculadorDeCostoDeEntrega = new CalculadorDeCostoDeEntrega();
    private GeneradorDeEnvios generadorDeEnvios = new GeneradorDeEnvios();

    @PostMapping(path = "/calcular-costo-envio")
    public Integer calcularCosto(@RequestBody PedidoDeEnvio pedido){
        return calculadorDeCostoDeEntrega.calcular(pedido.getProductos(), pedido.getTipoCliente());
    }

    @PostMapping(path = "/solicitar-entrega")
    public ResponseEntity<Envio> solicitarEntrega(@RequestBody PedidoDeEnvio pedido){
        try {
            Envio envio = generadorDeEnvios.generar(pedido.getProductos(), pedido.getDireccionDeEntrega());
            return ResponseEntity.ok(envio);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/comprar")
    public Factura comprar(@RequestBody OrdenDeCompra compra){
        return facturador.facturar(compra.getCliente(), compra.getItems());
    }

    // IoC setters
    public void setFacturador(Facturador facturador) {
        this.facturador = facturador;
    }

    public void setCalculadorDeCostoDeEntrega(CalculadorDeCostoDeEntrega calculadorDeCostoDeEntrega) {
        this.calculadorDeCostoDeEntrega = calculadorDeCostoDeEntrega;
    }

    public void setGeneradorDeEnvios(GeneradorDeEnvios generadorDeEnvios) {
        this.generadorDeEnvios = generadorDeEnvios;
    }
}
