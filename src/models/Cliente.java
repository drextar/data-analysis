package models;

public class Cliente {

    private Long cnpj;

    private String name;

    private String businessArea;

    public Cliente() {
    }

    public Cliente(Long cnpj, String name, String businessArea) {
        super();
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}
