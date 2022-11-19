package com.mycompany.exitotech.jar.database;

public class Funcionario {
    
    private Integer idFuncionario; 
    private String NomeFuncionario;
    private String CPF;
    private String email;
    private String senha;
    private String ativo;
    private String telefoneFuncionario;
    private String cep;
    private String fk_Empresa;
    private String isADM;
    private Integer qrCode; 

    public Integer getQrCode() {
        return qrCode;
    }

    public void setQrCode(Integer qrCode) {
        this.qrCode = qrCode;
    }
    
    

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFk_Empresa() {
        return fk_Empresa;
    }

    public void setFk_Empresa(String fk_Empresa) {
        this.fk_Empresa = fk_Empresa;
    }

    public String getIsADM() {
        return isADM;
    }

    public void setIsADM(String isADM) {
        this.isADM = isADM;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idFuncionario=" + idFuncionario + ", NomeFuncionario=" + NomeFuncionario + ", CPF=" + CPF + ", email=" + email + ", senha=" + senha + ", ativo=" + ativo + ", telefoneFuncionario=" + telefoneFuncionario + ", cep=" + cep + ", fk_Empresa=" + fk_Empresa + ", isADM=" + isADM + '}';
    }
    
    
    
}
