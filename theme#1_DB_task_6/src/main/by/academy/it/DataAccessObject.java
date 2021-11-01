package src.main.by.academy.it;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DataAccessObject {

    private DataSource dataSource = new DataSource();

    public void addingDataToExpensesTable() throws SQLException {

        Connection connection = dataSource.getConnection();
        String template =
                "SELECT name, SUM(value) AS sum " +
                        "FROM receivers r, expenses " +
                        "WHERE receiver = r.num " +
                        "GROUP BY name";
        ;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(template);
        while (resultSet.next()) {
            System.out.println("|  " + resultSet.getString("name") + "  |  "
                    + resultSet.getString("sum"));

        }


    }

    public void outputTable() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String template = "SELECT paydate, SUM(value) as sum " +
                "FROM expenses " +
                "WHERE paydate IN (" +
                "SELECT paydate " +
                "FROM expenses " +
                "WHERE value = (" +
                "SELECT MAX(value) " +
                "FROM expenses)) " +
                "GROUP BY paydate;";

        ResultSet resultSet = statement.executeQuery(template);
        while (resultSet.next()) {
            System.out.println("| " + resultSet.getString("paydate") + " | "
                    + resultSet.getString("sum") + " | "
            );
        }

        statement.close();
        connection.close();
    }
}

