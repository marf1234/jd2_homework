package src.main.by.academy.it.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataSource {

    public void Dao() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading JDCB driver" + cnfe);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/expensestable",
                "root",
                "root");
    }
}






