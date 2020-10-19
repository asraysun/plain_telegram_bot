package by.uniqo.telegrambot.service;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageService {

    @Autowired
    TelegramBot telegramBot;

    @Autowired
    LocaleMessageService localeMessage;
    @Autowired
    MainMenuButton mainMenuButton;

    public void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(mainMenuButton.getMainMenuKeyboard());
        try {
            telegramBot.execute(sendMessage);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
