package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TellMeMoreProcessor implements ProcessorI{
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    UserProfileData userProfileData;
    @Autowired
    TelegramBot telegramBot;

    @Override
    public String run() {
        SendMessage send = new SendMessage();
        send.setChatId((long) 1307084432);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
        send.setText(userProfileData.toStringTellMeMoreButton());
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
