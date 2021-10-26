package src.main.by.academy.it.data;

import java.sql.*;

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


}

