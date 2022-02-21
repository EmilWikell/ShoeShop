package Model;

public class OrderedItems {
    private PairOfShoes pairOfShoes;
    private CustomerOrder customerOrder;

    public OrderedItems(PairOfShoes pairOfShoes, CustomerOrder customerOrder) {
        this.pairOfShoes = pairOfShoes;
        this.customerOrder = customerOrder;
    }
}
