//package by.uniqo.telegrambot.model;
//
//import lombok.Data;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//@Component
//@Data
//@Entity
//@Table(name = "user_profile_data")
//public class UserProfileData implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//    @Column(name = "message_text")
//    String text;
//
//    @Column(name = "username")
//    String username;
//
//    @Column(name = "first_name")
//    String firstname;
//
//    @Column(name = "last_name")
//    String lastname;
//
//    @Column(name = "type_of_bot")
//    String typeOfBot;
//
//    @Column(name = "number_of_eployees")
//    String numberOfEmployees;
//
//    @Column(name = "bot_command")
//    String botCommand;
//
//    @Column(name = "timestamp")
//    Integer date;
//
//    @Column(name = "chat_id")
//    Long chatId;
//
//    private Date getDate(int date) {
//        return new java.util.Date((long) date * 1000);
//    }
//
////  TODO добавить для кнопки "Узнать больше" отображение даты, когда оно было отправлено
//
//    @Override
//    public String toString() {
//        return String.format("\n " + getText()
//                + "\nname: " + getUsername()
//                + "\nfirstname : " + getFirstname()
//                + "\nname: " + getLastname()
//                + "\nuserId: " + getId()
//                + "\ntypeOfBot: " + getTypeOfBot()
//                + "\nnumberOfEmployees: " + getNumberOfEmployees())
//                + "\nс какой кнопки пришел: " + getBotCommand();
////                + "\nпоследнее время обращения: " + getDate(date).toString();
//    }
//
//    public String toStringTellMeMoreButton() {
//        return String.format("\nnickname: " + getUsername()
//                + "\nfirstname : " + getFirstname()
//                + "\nname: " + getLastname()
//                + "\nuserId: " + getId()
//                + "\nс какой кнопки пришел: " + getBotCommand());
////                + "\nпоследнее время обращения: " + getDate(date).toString());
//    }
//}