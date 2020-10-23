package by.uniqo.telegrambot.service;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.InlineKeyboard.NumberOfEmployeesButtons;
import by.uniqo.telegrambot.buttons.InlineKeyboard.PriceButtons;
import by.uniqo.telegrambot.buttons.InlineKeyboard.Step1buttons;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButton;
import by.uniqo.telegrambot.enums.BotCommand;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.Objects;

@Service
public class MessageService {

    @Autowired
    TelegramBot telegramBot;

    @Autowired
    LocaleMessageService localeMessage;
    @Autowired
    MainMenuButton mainMenuButton;
    @Autowired
    PriceButtons priceButtons;
    @Autowired
    RequestDispatcher requestDispatcher;
    @Autowired
    Step1buttons step1buttons;
    @Autowired
    NumberOfEmployeesButtons numberOfEmployeesButtons;

    public void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
//        if (message.getChatId() == null) {
//            telegramBot.execute() // TODO сдделать юзер профиль для того, чтобы брать оттуда chatID 21.10.2020
//        }
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setParseMode("HTML");
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(mainMenuButton.getMainMenuKeyboard());
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageWithCallBackQuery(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        if (text.startsWith("СТОЙ")) {
            sendMessage.setReplyMarkup(step1buttons.getButtonsMarkupStep1());
        } else if (text.startsWith("Выбери")) {
            sendMessage.setReplyMarkup(priceButtons.getGenderButtonsMarkup());
        } else if (text.startsWith("Укажите кол")) {
            sendMessage.setReplyMarkup(numberOfEmployeesButtons.getNumberOfEmployeesButtonsMarkup());
        }

        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageText(String chatId, String text) {
        SendMessage send = new SendMessage();
        send.setChatId(chatId);
        send.setText(text);
        try {
            telegramBot.execute(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
