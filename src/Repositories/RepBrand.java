package Repositories;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import Model.Brand;

public class RepBrand {
    private final Properties p = new Properties();
    public RepBrand() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Brand> getBrandList() {

        List<Brand> listOfBrands = new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from brand")) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                listOfBrands.add(new Brand(res.getInt("id"), res.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfBrands;
    }
}
