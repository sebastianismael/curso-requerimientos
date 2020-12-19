package edu.sbe.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorBase {

    private static Logger logger = LoggerFactory.getLogger(ControladorBase.class);

    @GetMapping(path = "/isAlive")
    public String smoke(){
        return "=)";
    }
}
