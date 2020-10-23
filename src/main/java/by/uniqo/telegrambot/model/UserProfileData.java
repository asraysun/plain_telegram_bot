package by.uniqo.telegrambot.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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

    long chatId;


    @Override
    public String toString() {
        return String.format("\n "+ getText()
                + "\nname: "+ getUsername()
                + "\nfirstname : "+ getFirstname()
                + "\nname: "+ getLastname()
                + "\nuserId: " + getId()
                + "\ntypeOfBot: " + getTypeOfBot()
                + "\nnumberOfEmployees: " + getNumberOfEmployees());
    }
}