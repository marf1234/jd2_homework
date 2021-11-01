package src.main.by.academy.it;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DataAccessObject {

    private DataSource dataSource = new DataSource();

    public void addingDataToExpensesTable(String num, String date, String receiver, String value) throws SQLException {

        Connection connection = dataSource.getConnection();
        String template = "INSERT INTO expenses (paydate, receiver, value) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(template);
        preparedStatement.setString(1, num);
        preparedStatement.setString(2, date);
        preparedStatement.setString(3, receiver);
        preparedStatement.setString(4, value);

    }

    public void outputTable() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT paydate, value, name FROM expenses, " +
                "receivers WHERE receiver=receivers.num;");

        while (resultSet.next()) {
            System.out.println("| "
                    + resultSet.getDate("paydate") + " | "
                    + resultSet.getInt("value") + " | "
                    + resultSet.getString("name") + " | "
            );
        }

        statement.close();
        connection.close();
    }
}

