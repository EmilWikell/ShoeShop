package Repositories;

import Model.Shoe;
import Model.ShoeType;

import java.io.FileInputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class RepTypeOfShoe {
    private final Properties p = new Properties();
    public RepTypeOfShoe() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void connectShoeToType(List<Shoe> shoeList, List<ShoeType> shoeTypeList) {

        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from typeofshoe")) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                int shoeid = res.getInt("shoeid");
                int typeid = res.getInt("shoetypeId");
                Shoe currentShoe = shoeList.stream().filter(e -> e.getId()==shoeid).toList().get(0);
                currentShoe.addToShoeType(shoeTypeList.stream().filter(e -> e.getId()==typeid).toList().get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}