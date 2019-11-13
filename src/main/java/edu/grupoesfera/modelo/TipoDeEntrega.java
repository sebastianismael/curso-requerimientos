package edu.grupoesfera.modelo;

public enum TipoDeEntrega {
    GRATUITA(0), STANDARD(100);

    int costo;
    TipoDeEntrega(int costo){
        this.costo = costo;
    }

    public int costo(){
        return costo;
    }

}
