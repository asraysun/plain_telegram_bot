//package by.uniqo.telegrambot.processor;
//
//import java.sql.*;
//@
//public class JdbcProcessor {
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/our_telegram";
//
//    // JDBC Database Credentials
//    static final String JDBC_USER = "root";
//    static final String JDBC_PASS = "admin@123";
//
//    public void sendQuery() throws ClassNotFoundException {
//        try {
//            Class.forName(JDBC_DRIVER);
//            Connection connObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
//            connObj.setAutoCommit(false);
//            Statement stmtObj = connObj.createStatement();
//            String correctQuery = "INSERT INTO employee VALUES (001, 20, 'Java', 'Geek')";
//            stmtObj.executeUpdate(correctQuery);
//
//            PreparedStatement prepStmtObj = connObj.prepareStatement("SELECT DISTINCT item FROM order where order_id=?");
//
//            ResultSet resultSetObj = prepStmtObj.executeQuery();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }
//}
//
//try {
//        Class.forName(JDBC_DRIVER);
//        Connection connObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
//        connObj.setAutoCommit(false);
//        Statement stmtObj = connObj.createStatement();
//        String nick = message.getFrom().getUserName();
//        String correctQuery = "INSERT INTO user_profile_data (username) VALUES (nick); ";
//        stmtObj.executeUpdate(correctQuery);
//
//        connObj.commit();
//
//
//        } catch (SQLException | ClassNotFoundException throwables) {
//        throwables.printStackTrace();
//        }

