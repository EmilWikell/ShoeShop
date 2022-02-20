package Repositories;


import Model.Brand;
import Model.Shoe;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class RepShoe {
    private final Properties p = new Properties();
    public RepShoe() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Shoe> getShoesList(List<Brand> brandList) {

        List<Shoe> listOfShoes = new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from shoe")) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                int brandId = res.getInt("brandid");
                Brand currentBrand = brandList.stream().filter(e -> e.getId()==brandId).toList().get(0);
                listOfShoes.add(new Shoe(res.getInt("id"), res.getString("color"), res.getInt("price"), res.getString("name"),currentBrand));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfShoes;
    }
}