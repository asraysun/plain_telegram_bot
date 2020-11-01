package by.uniqo.telegrambot.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

@Data
@Component
public class TransferDTO implements Serializable{

    private Long id;
    private String text;
    private String username;
    private String firstname;
    private String lastname;
    private String typeOfBot;
    private String numberOfEmployees;
    private String botCommand;
    private Integer date;
    private Long chatId;
    private Integer messageId;

    @Autowired
    UserProfileData userProfileData;

    private Date getDate(int date) {
        return new java.util.Date((long) date * 1000);
    }

//  TODO добавить для кнопки "Узнать больше" отображение даты, когда оно было отправлено

    @Override
    public String toString() {
        return String.format("\n " + getText()
                + "\nname: " + getUsername()
                + "\nfirstname : " + getFirstname()
                + "\nname: " + getLastname()
                + "\nuserId: " + getId()
                + "\ntypeOfBot: " + getTypeOfBot()
                + "\nnumberOfEmployees: " + getNumberOfEmployees())
                + "\nс какой кнопки пришел: " + getBotCommand()
                + "\nпоследнее время обращения: " + getDate(date).toString();
    }

    public String toStringTellMeMoreButton() {
        Date dateTime=java.util.Calendar.getInstance().getTime();
        return String.format("\nnickname: " + getUsername()
                + "\nfirstname : " + getFirstname()
                + "\nname: " + getLastname()
                + "\nuserId: " + getId()
                + "\nс какой кнопки пришел: " + getBotCommand())
                + "\nпоследнее время обращения: " + dateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setTextToDB(UserProfileData userProfileData, TransferDTO transferDTO) {
//        userProfileData.setText(transferDTO.getText());
//
//    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTypeOfBot(String typeOfBot) {
        this.typeOfBot = typeOfBot;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setBotCommand(String botCommand) {
        this.botCommand = botCommand;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    private String submitSqlQuery(String correctQuery){
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
        return "";
    }
}