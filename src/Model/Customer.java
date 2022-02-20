package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String streetAdress;
    private String town;
    private String customerPassword;
    private List<CustomerOrder> orderList = new ArrayList<>();

    public Customer(int id, String firstName, String lastName, String streetAdress, String town) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAdress = streetAdress;
        this.town = town;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStreetAdress() {
        return streetAdress;
    }
    public String getTown() {
        return town;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }
    public List<CustomerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CustomerOrder> orderList) {
        this.orderList = orderList;
    }

    public void addOrderToList(CustomerOrder order){
        orderList.add(order);
    }
}
