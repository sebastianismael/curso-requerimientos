package edu.grupoesfera.aceptacion.cucumber.steps;

public enum Entrega {
    GRATUITA(0), STANDARD(100);

    int costo;
    Entrega(int costo){
        this.costo = costo;
    }

}
