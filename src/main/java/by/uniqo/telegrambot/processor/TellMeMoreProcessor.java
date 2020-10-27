package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.service.UserProfileDataService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.PreparedStatement;

@Service
public class TellMeMoreProcessor implements ProcessorI{
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    UserProfileDataService userProfileDataService;
    @Autowired
    TelegramBot telegramBot;

    @Override
    public String run() {
        SendMessage send = new SendMessage();
        send.setChatId((long) 1307084432);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
//        try {
//            Class.forName(JDBC_DRIVER);
//            Connection connObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
//
//            PreparedStatement prepStmtObj = new PreparedStatement("SELECT DISTINCT item FROM order where order_id=?");
//            prepStmtObj.setString(0, "101"); // This Will Throw "java.sql.SQLException: Invalid Column Index" Because "0" Is Not Valid Colum Index
//
//            ResultSet resultSetObj = prepStmtObj.executeQuery();
//            while(resultSetObj.next()) {
//                System.out.println("Item: " + resultSetObj.getString(2)); // This Will Throw "java.sql.SQLException: Invalid column index" Because ResultSet Has Only One Column
//            }
//        } catch (Exception sqlException) {
//            sqlException.printStackTrace();
//        }
        send.setText("");
        try {
            telegramBot.execute(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return localeMessageService.getMessage("reply.tellMeMore");

    }


//    TODO when creating message to user, split a message and emogis into to methods
//    public String run_redundant() {
//        return localeMessageService.getMessage("reply.tellMeMore", Emojis.CHECK, Emojis.CHECK,
//                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK);
//    }
}
