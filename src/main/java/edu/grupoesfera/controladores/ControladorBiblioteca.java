package edu.grupoesfera.controladores;

import edu.grupoesfera.dto.Pedido;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBiblioteca {

    @PostMapping(path = "/calcular-costo-envio")
    public Integer calcularCosto(Pedido pedido){
        return 0;
    }
}
