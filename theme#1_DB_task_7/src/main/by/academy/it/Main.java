package src.main.by.academy.it;


import src.main.by.academy.it.data.Dao.DataAccessObject;
import src.main.by.academy.it.data.Dto.Expense;
import src.main.by.academy.it.data.Dto.Receiver;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        DataAccessObject dataAccessObject = new DataAccessObject();

        Expense expense = new Expense();
        expense.setPaydate("2021-11-01");
        expense.setReceiver("GMBH_Vegera");
        expense.setValue(2000);
        dataAccessObject.addExpense(expense);

        expense.setPaydate("2020-00-00");
        expense.setReceiver("LLC_Dima");
        expense.setValue(1000);
        dataAccessObject.addExpense(expense);

        expense.setPaydate("2021-11-01");
        expense.setReceiver("OOO_Marina");
        expense.setValue(3000);
        dataAccessObject.addExpense(expense);

        Receiver receiver = new Receiver();

        receiver.setNum(1);
        receiver.setName("OOO_Marina");
        dataAccessObject.addReceiver(receiver);

        receiver.setNum(2);
        receiver.setName("LLC_Dima");
        dataAccessObject.addReceiver(receiver);

        ArrayList<Expense> receivers = dataAccessObject.getExpense();
        receivers.forEach(System.out::println);

        ArrayList<Expense> expenses = dataAccessObject.getExpense();
        expenses.forEach(System.out::println);

    }
}
