package edu.grupoesfera.modelo;

public enum Entrega {
    GRATUITA(0), STANDARD(100);

    int costo;
    Entrega(int costo){
        this.costo = costo;
    }

    public int costo(){
        return costo;
    }

}
