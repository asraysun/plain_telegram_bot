package by.uniqo.telegrambot.cache;

import by.uniqo.telegrambot.api.handlers.BotState;
import by.uniqo.telegrambot.api.handlers.fillingProfile.UserProfileData;

public interface DataCache {
    void setUsersCurrentBotState(int userId, BotState botState);

    BotState getUsersCurrentBotState(int userId);

    UserProfileData getUserProfileData(int userId);

    void saveUserProfileData(int userId, UserProfileData userProfileData);
}
