package Repositories;


import Model.CustomerOrder;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepCustomerOrder {
    private final Properties p = new Properties();
    public RepCustomerOrder() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<CustomerOrder> getOrderList(int customerId) {

        List<CustomerOrder> orderList = new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from customerorder where CuSTOMerId="+customerId)) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                orderList.add(new CustomerOrder(res.getInt("id"), res.getString("createdDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}