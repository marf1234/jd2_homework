package src.main.by.academy.it;


import java.sql.SQLException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        DataAccessObject dataAccessObject = new DataAccessObject();
        dataAccessObject.addingDataToExpensesTable();
        System.out.println();
        dataAccessObject.outputTable();

    }
}
