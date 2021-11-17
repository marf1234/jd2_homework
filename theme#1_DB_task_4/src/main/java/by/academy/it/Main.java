package by.academy.it;


import java.sql.SQLException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        DataAccessObject dataAccessObject = new DataAccessObject();
        dataAccessObject.addingDataToExpensesTable(args[0], args[1], args[2], args[3]);
        dataAccessObject.outputTable();

    }
}
