package models;

import java.util.List;

public class Venda {
    private Long saleId;

    private List<Item> listItems;

    private String salesmanName;

    public Venda() {}

    public Venda(Long saleId, List<Item> listItems, String salesmanName) {
        super();
        this.saleId = saleId;
        this.listItems = listItems;
        this.salesmanName = salesmanName;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
}
