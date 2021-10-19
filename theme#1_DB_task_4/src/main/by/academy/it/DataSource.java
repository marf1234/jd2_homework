package src.main.by.academy.it;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataSource {

    public DataSource() throws SQLException {
    }

    public void TicketDao() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading JDCB driver" + cnfe);
        }
    }
   public Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/parking",
            "root",
            "root");
    Statement statement =conn.createStatement();
    String query ="SELECT value FROM exspenses";
    ResultSet rs = statement.executeQuery(query);

    public List<String> readAllTickets() throws SQLException {

        while(rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setLicensePlateNumber(rs.getString("car_number"));
            ticket.setDate(rs.getTimestamp("ticket_date"));
            ticketList.add(ticket);
        }
        st.close();
        con.close();
        return ticketList;
    }
}







//public class TicketDao {
//
//    public TicketDao() throws ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//    }
//
//    protected Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/parking",
//                "root",
//                "root");
//    }
//
//    public List<Ticket> readAllTickets() throws SQLException {
//        Connection con = getConnection();
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM parking.tickets");
//        List<Ticket> ticketList = new ArrayList<>();
//        while(rs.next()) {
//            Ticket ticket = new Ticket();
//            ticket.setLicensePlateNumber(rs.getString("car_number"));
//            ticket.setDate(rs.getTimestamp("ticket_date"));
//            ticketList.add(ticket);
//        }
//        st.close();
//        con.close();
//        return ticketList;
//    }
//
//}