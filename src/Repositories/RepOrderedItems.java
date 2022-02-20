package Repositories;


import Model.CustomerOrder;
import Model.PairOfShoes;
import Model.Shoe;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepOrderedItems {
    private final Properties p = new Properties();
    public RepOrderedItems() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<PairOfShoes> getOrderedItems(CustomerOrder customerOrder,List<Shoe> shoeList){

        List<PairOfShoes> orderedItemsList = new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select pairOfShoes.id as pairId, size, inventory,shoe.id as shoeId from ordereditems " +
                     "inner join pairofshoes on PairOFShoesID=pairofshoes.id " +
                     "inner join shoe on shoe.id=pairofshoes.ShOEID where cUSTOMerOrderId=" +customerOrder.getId())){
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                int shoeId = res.getInt("shoeId");
                orderedItemsList.add(new PairOfShoes(res.getInt("pairId"), res.getInt("size"), res.getInt("inventory")
                        ,shoeList.stream().filter(e -> e.getId()== shoeId).toList().get(0)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderedItemsList;
    }
}