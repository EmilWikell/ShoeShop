package Repositories;

import Model.Grade;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepGrade {
    private final Properties p = new Properties();
    public RepGrade() {
        try {
            p.load(new FileInputStream("src/Repositories/settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Grade> getGradeList(){

        List<Grade>  gradeList= new ArrayList<>();
        try (Connection dbcon = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("name"), p.getProperty("password"));
             CallableStatement stmt = dbcon.prepareCall("Select * from grade")) {
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                gradeList.add(new Grade(res.getInt("id"), res.getInt("value"), res.getString("keyword")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }
}