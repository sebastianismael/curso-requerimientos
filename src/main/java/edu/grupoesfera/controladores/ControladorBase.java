package edu.grupoesfera.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBase {

    @GetMapping(path = "/isAlive")
    public String smoke(){
        return "=)";
    }
}
