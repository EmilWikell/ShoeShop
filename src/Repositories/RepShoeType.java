package Repositories;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import Model.ShoeType;

public class RepShoeType {
    private final Properties p = new Properties();
    public RepShoeType() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<ShoeType> getShoeTypeList() {

        List<ShoeType> listOfShoeTypes = new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from shoetype")) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                listOfShoeTypes.add(new ShoeType(res.getInt("id"), res.getString("type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfShoeTypes;
    }
}