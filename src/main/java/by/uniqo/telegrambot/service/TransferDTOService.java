package by.uniqo.telegrambot.service;

import by.uniqo.telegrambot.model.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class TransferDTOService {

    @Autowired
    TransferDTO transferDTO;

    public TransferDTO getTransferDTO() {
        return transferDTO;
    }

    private void submitSqlQuery(String correctQuery){
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/our_telegram?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

        final String JDBC_USER = "root";
        final String JDBC_PASS = "1234";
        try {
            Class.forName(JDBC_DRIVER);
            Connection connObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
            connObj.setAutoCommit(false);
            Statement stmtObj = connObj.createStatement();
            stmtObj.executeUpdate(correctQuery);

            connObj.commit();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
