package by.uniqo.telegrambot.api.handlers.fillingProfile;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Данные анкеты пользователя
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileData {
    long chat_id;
    int user_id;
    String name;
    String gender;
    String color;
    String movie;
    String song;
    int age;
    int number;
    String currentBotState;
}
