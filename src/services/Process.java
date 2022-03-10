package services;

import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Process {
    public void processarRegistros(String fileName) throws IOException {
        String pathIN = System.getProperty("user.home") + "\\data\\in\\" + fileName;

        String[] splitName = fileName.split("\\.");

        String pathOUT = System.getProperty("user.home") + "\\data\\out\\" + splitName[0] + ".done." + splitName[1];

        List<Registro> registros = new ArrayList<Registro>();
        ReadFile readFile = new ReadFile();

        registros = readFile.read(pathIN);

        int qtdeClientes = 0;
        int qtdeVendedores = 0;
        Long idVendaMaisCara = 0L;
        String piorVendedor = primeiraVenda(registros).getSalesmanName();
        Double maiorVenda = 0.0;
        Double menorVenda = totalVenda(primeiraVenda(registros)); //seta a primeira venda como a menor

        for (Registro registro : registros) {

            if (registro.getCliente() != null) {
                qtdeClientes++;
            }

            if (registro.getVendedor() != null) {
                qtdeVendedores++;
            }

            if (registro.getVenda() != null) {
                if (totalVenda(registro.getVenda()) > maiorVenda) {
                    maiorVenda = totalVenda(registro.getVenda());
                    idVendaMaisCara = registro.getVenda().getSaleId();
                }

                if (totalVenda(registro.getVenda()) < menorVenda) {
                    menorVenda = totalVenda(registro.getVenda());
                    piorVendedor = registro.getVenda().getSalesmanName();
                }
            }
        }

        /**
         * Preparando resposta e escrevendo no novo arquivo
         */
        String response = "Quantidade de clientes: " + qtdeClientes + "\n";
        response += "Quantidade de vendedores: " + qtdeVendedores + "\n";
        response += "ID da venda mais cara: " + idVendaMaisCara + "\n";
        response += "O pior vendedor: " + piorVendedor;

        WriteFile writeFile = new WriteFile();
        writeFile.write(response, pathOUT);
    }

    /**
     * Calcula o valor total de uma venda
     * @param venda
     * @return valor total
     */
    private Double totalVenda(Venda venda) {
        Double totalVenda = 0d;

        for (Item item : venda.getListItems()) {
            totalVenda += item.getItemPrice();
        }

        return totalVenda;
    }

    /**
     * Retornar a primeira venda da lista
     * @param registros
     */
    private Venda primeiraVenda(List<Registro> registros) {
        for (Registro registro : registros) {

            if (registro.getVenda() != null) {
                return registro.getVenda();
            }
        }

        return new Venda();
    }

    /**
     * Identifica o tipo de registro de cada linha e retorna um objeto do tipo
     * registro, este objeto contém um atributo para cada tipo de registro, ou seja,
     * cada objeto pode ser um dos tipos Vendedor, Cliente ou Venda.
     *
     * @param line
     * @return Registro
     */
    public Registro identificarLinha(String[] line) {
        Registro registro = new Registro();

        switch (Integer.parseInt(line[0])) {
            case 1: {
                Vendedor vendedor = new Vendedor(Long.parseLong(line[1]), line[2], Double.parseDouble(line[3]));
                registro.setVendedor(vendedor);
                break;
            }

            case 2: {
                Cliente cliente = new Cliente(Long.parseLong(line[1]), line[2], line[3]);
                registro.setCliente(cliente);
                break;
            }

            case 3: {
                montarListaDeIntens(line[2]);
                Venda venda = new Venda(Long.parseLong(line[1]), montarListaDeIntens(line[2]), line[3]);
                registro.setVenda(venda);
                break;
            }
        }

        return registro;
    }

    /**
     * Monta e retorna a lista de itens da venda
     *
     * @param lista
     */
    private static List<Item> montarListaDeIntens(String lista) {
        String[] listaItens = lista.split(",");

        List<Item> itensCompra = new ArrayList<Item>();

        for (int i = 0; i < listaItens.length; i++) {
            itensCompra.add(montarItens(listaItens[i]));
        }

        return itensCompra;
    }

    /**
     * Monta um objeto Item com as informações da lista da venda
     *
     * @param stringItem
     * @return Item
     */
    private static Item montarItens(String stringItem) {
        stringItem = stringItem.replace("[", "");
        stringItem = stringItem.replace("]", "");

        String[] itens = stringItem.split("-");

        Item item = new Item(Long.parseLong(itens[0]), Integer.parseInt(itens[1]), Double.parseDouble(itens[2]));

        return item;
    }
}
