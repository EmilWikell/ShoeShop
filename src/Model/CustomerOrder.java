package Model;

import java.util.List;

public class CustomerOrder {
    private int id;
    private String date;
    private List<PairOfShoes> listPairOfShoes;

    public CustomerOrder(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<PairOfShoes> getListPairOfShoes() {
        return listPairOfShoes;
    }
    public void setListPairOfShoes(List<PairOfShoes> listPairOfShoes) {
        this.listPairOfShoes = listPairOfShoes;
    }


}