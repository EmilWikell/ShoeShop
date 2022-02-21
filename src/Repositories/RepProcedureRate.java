package Repositories;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class RepProcedureRate {
    private final Properties p = new Properties();
    public RepProcedureRate() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String callProcedureRate(int customerId, int shoeId, int gradeId, String comment) {

        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Call Rate("+customerId+","+shoeId+","+gradeId+",?)")) {
            stmt.setString(1, comment);
            stmt.execute();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "Success";
    }
}