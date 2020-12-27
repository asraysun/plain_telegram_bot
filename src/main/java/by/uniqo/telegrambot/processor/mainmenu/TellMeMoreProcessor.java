package by.uniqo.telegrambot.processor.mainmenu;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButtonForAdditionMenu;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import by.uniqo.telegrambot.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TellMeMoreProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    MainMenuButtonForAdditionMenu mainMenuButtonForAdditionMenu;
    @Autowired
    UserProfileRepository userProfileRepository;
    public static long chatId;

    @Override
    public String run() {
        if (userProfileRepository.findUserProfileDataByChatId(chatId) != null) {
            UserProfileData userProfileData = userProfileRepository.findUserProfileDataByChatId(chatId);
            SendMessage send = new SendMessage();
        SendMessage send1 = new SendMessage();
            SendContact sendContact = new SendContact();

            send.setChatId((long) 1307084432);
            send.setText(userProfileData.toStringTellMeMoreButton());
//        send1.setChatId((long) 764602851);
        send1.setText(userProfileData.toStringTellMeMoreButton());
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
            //956524755 - мой ид
            sendContact.setReplyToMessageId(send.getReplyToMessageId());
            sendContact.setChatId(userProfileData.getChatId());
            sendContact.setPhoneNumber("+37544 735 7152");
            sendContact.setFirstName("Антон");
            sendContact.setLastName("Купрейчик");
            sendContact.setReplyMarkup(mainMenuButtonForAdditionMenu.getAdditionMenuKeyboard());
            try {
                telegramBot.execute(send);
//            telegramBot.execute(send1);
                telegramBot.execute(sendContact);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return "Наш менеджер расскажет вам подробности";

    }

//    TODO when creating message to user, split a message and emojis into to methods
//    public String run_redundant() {
//        return localeMessageService.getMessage("reply.tellMeMore", Emojis.CHECK, Emojis.CHECK,
//                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK);
//    }
}
