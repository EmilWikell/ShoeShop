package Repositories;

import Model.Customer;
import Model.CustomerOrder;

import java.io.FileInputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class RepCustomer {
    private final Properties p = new Properties();
    public RepCustomer() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int VerifyLogin(String firstName, String lastName, String passWord) {

        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from customer where FiRSTName=? and lASTNAme=? and customerPassword=?")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, passWord);
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
                while (res.next()) {
                    return res.getInt("id");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Customer loginCustomer(int customerId){
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from customer where id=" + customerId)) {
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                Customer customer = new Customer(res.getInt("id"), res.getString("firstName"), res.getString("lastName"), res.getString("streetAdress"), res.getString("town"));
                customer.setOrderList(new RepCustomerOrder().getOrderList(customerId));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}