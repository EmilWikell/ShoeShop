package Repositories;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class RepRating {
    private final Properties p = new Properties();
    public RepRating() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String showRating(int idShoe) {
        StringBuilder allComments = new StringBuilder();


        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("select getAvgGrade(shoe.id) as score from shoe where shoe.id="+idShoe)) {
            stmt.executeQuery();
            double score = 0;
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                score = res.getDouble("score");
            }
            if (score == 0){
                return "Not yet rated";
            }
            allComments.append("Score: ").append(String.format("%.1f",score)).append("\nComments: \n");
        } catch (SQLException e) {
            allComments.append(e.getMessage());
        }
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select Customer.firstName,cOMMENt from rating " +
                     "inner join customer on rating.cuSTOMerID = customer.id " +
                     "where rating.sHOEID="+idShoe)) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                allComments.append(res.getString("firstname")).append("\n").append(res.getString("comment")).append("\n******************************************\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(allComments);
    }
}
