package com.mycompany.exitotech.jar.conexaojdbc;

public class Empresa {
    
    private Integer id_empresa; 
    private String Nome;
    private String Cnpj;
    private String EmailEmpresa;
    private String SenhaEmpresa;
    private String PorteEmpresa;
    private String Logradouro;
    private String UF;
    private String CEP;

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getEmailEmpresa() {
        return EmailEmpresa;
    }

    public void setEmailEmpresa(String EmailEmpresa) {
        this.EmailEmpresa = EmailEmpresa;
    }

    public String getSenhaEmpresa() {
        return SenhaEmpresa;
    }

    public void setSenhaEmpresa(String SenhaEmpresa) {
        this.SenhaEmpresa = SenhaEmpresa;
    }

    public String getPorteEmpresa() {
        return PorteEmpresa;
    }

    public void setPorteEmpresa(String PorteEmpresa) {
        this.PorteEmpresa = PorteEmpresa;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id_empresa=" + id_empresa + ", Nome=" + Nome + ", Cnpj=" + Cnpj + ", EmailEmpresa=" + EmailEmpresa + ", SenhaEmpresa=" + SenhaEmpresa + ", PorteEmpresa=" + PorteEmpresa + ", Logradouro=" + Logradouro + ", UF=" + UF + ", CEP=" + CEP + '}';
    }
    
    
    
}
