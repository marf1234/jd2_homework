package src.main.by.academy.it.data.Dao;

import src.main.by.academy.it.data.DataSource;
import src.main.by.academy.it.data.Dto.Expense;
import src.main.by.academy.it.data.Dto.Receiver;

import java.sql.*;
import java.util.ArrayList;

public class DataAccessObject {

    private DataSource dataSource = new DataSource();

    public Receiver getReceiver(int num) throws SQLException {

        Connection connection = dataSource.getConnection();
        String template = "SELECT * FROM receivers WHERE num = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(template);
        preparedStatement.setInt(1, num);
        ResultSet resultSet = preparedStatement.executeQuery();
        Receiver receiver = null;
        while (resultSet.next()) {
            receiver = new Receiver();
            receiver.setName(resultSet.getString("name"));
            receiver.setNum(resultSet.getInt("num"));
        }
        preparedStatement.close();
        connection.close();
        return receiver;
    }

    public ArrayList<Receiver> getRecievers() throws SQLException {
        Connection connection = dataSource.getConnection();
        String template = "SELECT * FROM receivers;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(template);
        ArrayList<Receiver> recieverslist = new ArrayList<>();
        Receiver receiver;
        while (resultSet.next()) {
            receiver = new Receiver();
            receiver.setNum(resultSet.getInt("num"));
            receiver.setName(resultSet.getString("name"));
        }
        statement.close();
        connection.close();
        return recieverslist;
    }

    public Expense getExpense(int num) throws SQLException {

        Connection connection = dataSource.getConnection();
        String template = "SELECT * FROM expense WHERE num = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(template);
        preparedStatement.setInt(1, num);
        ResultSet resultSet = preparedStatement.executeQuery();
        Expense expense = null;
        while (resultSet.next()) {
            expense = new Expense();
            expense.setNum(resultSet.getInt("num"));
            expense.setPaydate(resultSet.getString("paydate"));
            expense.setReceiver(resultSet.getString("receiver"));
            expense.setValue(resultSet.getDouble("value"));
        }
        preparedStatement.close();
        connection.close();
        return expense;
    }

    public ArrayList<Expense> getExpense() throws SQLException {
        Connection connection = dataSource.getConnection();
        String template = "SELECT * FROM expenses;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(template);
        ArrayList<Expense> expenseslist = new ArrayList<>();
        Expense expense;
        while (resultSet.next()) {
            expense = new Expense();
            expense.setNum(resultSet.getInt("num"));
            expense.setPaydate(resultSet.getString("paydate"));
            expense.setReceiver(resultSet.getString("receiver"));
            expense.setValue(resultSet.getDouble("value"));
        }
        statement.close();
        connection.close();
        return expenseslist;
    }

    public int addReceiver(Receiver receiver) throws SQLException {
        Connection connection = dataSource.getConnection();
        String template = "INSERT INTO receivers VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(template);
        preparedStatement.setInt(1, receiver.getNum());
        preparedStatement.setString(2, receiver.getName());
        return preparedStatement.executeUpdate();
    }


    public int addExpense(Expense expense) throws SQLException {
        Connection connection = dataSource.getConnection();
        String template = "INSERT INTO expenses VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(template);
        preparedStatement.setInt(1, expense.getNum());
        preparedStatement.setString(2, expense.getPaydate());
        preparedStatement.setString(3, expense.getReceiver());
        preparedStatement.setDouble(4, expense.getValue());
        return preparedStatement.executeUpdate();
    }
}



