package Model;

public class SoldOut {
    private int id;
    private PairOfShoes pairOfShoes;
    private String soldOutDate;

    public SoldOut(int id, PairOfShoes pairOfShoes, String soldOutDate) {
        this.id = id;
        this.pairOfShoes = pairOfShoes;
        this.soldOutDate = soldOutDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PairOfShoes getPairOfShoes() {
        return pairOfShoes;
    }

    public void setPairOfShoes(PairOfShoes pairOfShoes) {
        this.pairOfShoes = pairOfShoes;
    }

    public String getSoldOutDate() {
        return soldOutDate;
    }

    public void setSoldOutDate(String soldOutDate) {
        this.soldOutDate = soldOutDate;
    }
}
