package com.mycompany.exitotech.jar.database;

public class Maquina {
    private Integer idMaquina;
    private String nomeMaquina;
    private Integer fk_setor;
    private String SistemaOperacional;
    private String processador;
    private String memoriaRam;
    private String memoriaMassa;

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

    public Integer getFk_setor() {
        return fk_setor;
    }

    public void setFk_setor(Integer fk_setor) {
        this.fk_setor = fk_setor;
    }

    public String getSistemaOperacional() {
        return SistemaOperacional;
    }

    public void setSistemaOperacional(String SistemaOperacional) {
        this.SistemaOperacional = SistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getMemoriaMassa() {
        return memoriaMassa;
    }

    public void setMemoriaMassa(String memoriaMassa) {
        this.memoriaMassa = memoriaMassa;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + ", nomeMaquina=" + nomeMaquina + ", fk_setor=" + fk_setor + ", SistemaOperacional=" + SistemaOperacional + ", processador=" + processador + ", memoriaRam=" + memoriaRam + ", memoriaMassa=" + memoriaMassa + '}';
    }
    
}
