package Repositories;


import Model.PairOfShoes;
import Model.Shoe;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepPairOfShoes {
    private final Properties p = new Properties();
    public RepPairOfShoes() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<PairOfShoes> getListPairOfShoes(Shoe shoe) {

        List<PairOfShoes> listPairOfShoes = new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from pairofshoes where ShOEID="+shoe.getId())) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                listPairOfShoes.add(new PairOfShoes(res.getInt("id"), res.getInt("size"), res.getInt("inventory"), shoe));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPairOfShoes;
    }
}