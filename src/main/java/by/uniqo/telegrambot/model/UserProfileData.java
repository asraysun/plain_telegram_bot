package by.uniqo.telegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profile_data")
public class UserProfileData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "message_text")
    String text;

    @Column(name = "username")
    String username;

    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

    @Column(name = "type_of_bot")
    String typeOfBot;

    @Column(name = "number_of_eployees")
    String numberOfEmployees;

    @Column(name = "bot_command")
    String botCommand;

    @Column(name = "timestamp")
    Integer date;

    @Column(name = "chat_id")
    Long chatId;


    private Date getDate(int date) {
        return new java.util.Date((long) date * 1000);
    }

//  TODO добавить для кнопки "Узнать больше" отображение даты, когда оно было отправлено

    @Override
    public String toString() {
        Date dateTime=java.util.Calendar.getInstance().getTime();
        return String.format("\n " + getText()
                + "\nname: " + getUsername()
                + "\nfirstname : " + getFirstname()
                + "\nname: " + getLastname()
                + "\nidInDB: " + getId()
                + "\nuserId: " + getChatId()
                + "\ntypeOfBot: " + getTypeOfBot()
                + "\nnumberOfEmployees: " + getNumberOfEmployees())
                + "\nс какой кнопки пришел: " + getBotCommand()
                + "\nпоследнее время обращения: " + dateTime;
    }

    public String toStringTellMeMoreButton() {
        Date dateTime=java.util.Calendar.getInstance().getTime();
        return String.format("\nnickname: " + getUsername()
                + "\nfirstname : " + getFirstname()
                + "\nname: " + getLastname()
                + "\nidInDB: " + getId()
                + "\nuserId: " + getChatId()
                + "\nс какой кнопки пришел: " + getBotCommand())
                + "\nпоследнее время обращения: " + dateTime;
    }

    public String toStringJustClientsNames() {
        String answer = "";

        if(!getUsername().isEmpty()){
            answer.concat(getUsername().concat(getId().toString()));

        } else if(!getFirstname().isEmpty()) {
            answer.concat(getFirstname().concat(getId().toString()));
        }


        return answer;
    }
}