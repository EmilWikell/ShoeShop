package Model;



public class PairOfShoes {
    private int id;
    private int size;
    private int inventory;
    private Shoe shoe;


    public PairOfShoes(int id, int size, int inventory, Shoe shoe) {
        this.id = id;
        this.size = size;
        this.inventory = inventory;
        this.shoe = shoe;
    }

    public Shoe getShoe() {
        return shoe;
    }
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Model:" +shoe.getName() + ", Size:" + size + ", inventory:" + inventory;
    }
}
