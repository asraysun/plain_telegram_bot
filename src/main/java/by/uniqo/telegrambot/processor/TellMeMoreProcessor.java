package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButtonForAdditionMenu;
import by.uniqo.telegrambot.model.TransferDTO;
//import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.service.LocaleMessageService;
//import by.uniqo.telegrambot.service.UserProfileDataService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
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
    @Autowired
    MainMenuButtonForAdditionMenu mainMenuButtonForAdditionMenu;

    @Override
    public String run() {
        SendMessage send = new SendMessage();
        SendMessage send1 = new SendMessage();
        SendContact sendContact = new SendContact();

        send.setChatId((long) 1307084432);
        send.setText(transferDTO.toStringTellMeMoreButton());
        send1.setChatId((long) 764602851);
        send1.setText(transferDTO.toStringTellMeMoreButton());
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
        //956524755 - мой ид
        sendContact.setReplyToMessageId(send.getReplyToMessageId());
        sendContact.setChatId(transferDTO.getId());
        System.out.println(sendContact.setChatId(transferDTO.getId()));
        sendContact.setPhoneNumber("+37544 735 7152");
        sendContact.setFirstName("Антон");
        sendContact.setLastName("Купрейчик");
        sendContact.setReplyMarkup(mainMenuButtonForAdditionMenu.getAdditionMenuKeyboard());
        try {
            telegramBot.execute(send);
            telegramBot.execute(send1);
            telegramBot.execute(sendContact);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return "Наш менеджер расскажет вам подробности";

    }


//    TODO when creating message to user, split a message and emojis into to methods
//    public String run_redundant() {
//        return localeMessageService.getMessage("reply.tellMeMore", Emojis.CHECK, Emojis.CHECK,
//                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK);
//    }
}
