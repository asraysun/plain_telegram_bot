package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.TransferDTO;
//import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.service.LocaleMessageService;
//import by.uniqo.telegrambot.service.UserProfileDataService;
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
    TransferDTO transferDTO;
    @Autowired
    TelegramBot telegramBot;

    @Override
    public String run() {
        SendMessage send = new SendMessage();
        send.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya

        send.setText(transferDTO.toStringTellMeMoreButton());
        try {
            telegramBot.execute(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return localeMessageService.getMessage("reply.tellMeMore");

    }


//    TODO when creating message to user, split a message and emojis into to methods
//    public String run_redundant() {
//        return localeMessageService.getMessage("reply.tellMeMore", Emojis.CHECK, Emojis.CHECK,
//                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK);
//    }
}
