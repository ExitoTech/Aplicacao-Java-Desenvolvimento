package com.mycompany.exitotech.jar.database;

public class Maquina {
    private Integer idMaquina;
    private String nomeMaquina;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + ", nomeMaquina=" + nomeMaquina + '}';
    }
    
    
 
    
}
