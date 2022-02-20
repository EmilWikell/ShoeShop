package Repositories;


import Model.PairOfShoes;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class RepProcedureAddToCart {
    private final Properties p = new Properties();
    public RepProcedureAddToCart() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String callProcedure(int idCustomer, int idOrder, int idPairOfShoes) {
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Call AddToCart("+idCustomer+","+idOrder+","+idPairOfShoes+")")) {
            stmt.execute();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "Success";
    }
}