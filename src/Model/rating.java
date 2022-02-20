package Model;

public class rating {
    private int id;
    private Grade grade;
    private Customer customer;
    private Shoe shoe;
    private String comment;

    public rating(int id, Grade grade, Customer customer, Shoe shoe, String comment) {
        this.id = id;
        this.grade = grade;
        this.customer = customer;
        this.shoe = shoe;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
