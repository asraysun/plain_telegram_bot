package by.uniqo.telegrambot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data

@Component
public class UserProfileData implements Serializable {
    String id;
    String text;
    String username;
    String Firstname;
    String Lastname;
    String typeOfBot;
    String numberOfEmployees;
    String botCommand;
    Integer date;

    long chatId;

    private Date getDate(int date) {
        return new java.util.Date((long)date*1000);
    }


    @Override
    public String toString() {
        return String.format("\n "+ getText()
                + "\nname: "+ getUsername()
                + "\nfirstname : "+ getFirstname()
                + "\nname: "+ getLastname()
                + "\nuserId: " + getId()
                + "\ntypeOfBot: " + getTypeOfBot()
                + "\nnumberOfEmployees: " + getNumberOfEmployees())
                + "\nс какой кнопки пришел: " + getBotCommand()
                + "\nпоследнее время обращения: " + getDate(date).toString();
    }
    public String toStringTellMeMoreButton() {
        return String.format("\nnickname: "+ getUsername()
                + "\nfirstname : "+ getFirstname()
                + "\nname: "+ getLastname()
                + "\nuserId: " + getId()
                + "\nс какой кнопки пришел: " + getBotCommand()
                + "\nпоследнее время обращения: " + getDate(date).toString());
    }
}