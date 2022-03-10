package models;

public class Registro {

    private Vendedor vendedor;

    private Cliente cliente;

    private Venda venda;

    public Registro() {
    }

    public Registro(Vendedor vendedor, Cliente cliente, Venda venda) {
        super();
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.venda = venda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "Registro [vendedor=" + vendedor + ", cliente=" + cliente + ", venda=" + venda + "]";
    }
}
