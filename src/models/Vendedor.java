package models;

public class Vendedor {

    private Long cpf;

    private String name;

    private Double salary;

    public Vendedor() {
    }

    public Vendedor(Long cpf, String name, double salary) {
        super();
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
