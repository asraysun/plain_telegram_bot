package by.uniqo.telegrambot.service;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.InlineKeyboard.ManagerApproveButtons;
import by.uniqo.telegrambot.buttons.InlineKeyboard.NumberOfEmployeesButtons;
import by.uniqo.telegrambot.buttons.InlineKeyboard.PriceButtons;
import by.uniqo.telegrambot.buttons.InlineKeyboard.Step1buttons;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButton;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButtonForAdditionMenu;
import by.uniqo.telegrambot.model.TransferDTO;
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
    @Autowired
    MainMenuButtonForAdditionMenu mainMenuButtonForAdditionMenu;
    @Autowired
    PriceButtons priceButtons;
    @Autowired
    RequestDispatcher requestDispatcher;
    @Autowired
    Step1buttons step1buttons;
    @Autowired
    NumberOfEmployeesButtons numberOfEmployeesButtons;
    @Autowired
    ManagerApproveButtons managerApproveButtons;
    @Autowired
    TransferDTO transferDTO;

    public void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
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
    public void sendMessageWithAdditionMenu(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setParseMode("HTML");
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(mainMenuButtonForAdditionMenu.getAdditionMenuKeyboard());
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
        if (text.contains("Каждый бот")) {
            sendMessage.setReplyMarkup(step1buttons.getButtonsMarkupStep1());
        } else if (text.startsWith("Выбери")) {
            sendMessage.setReplyMarkup(priceButtons.getGenderButtonsMarkup());
        } else if (text.startsWith("Укажите кол")) {
            sendMessage.setReplyMarkup(numberOfEmployeesButtons.getNumberOfEmployeesButtonsMarkup());
        } else if (text.startsWith("Поделиться кон")) {
            sendMessage.setReplyMarkup(mainMenuButtonForAdditionMenu.getAdditionMenuKeyboard());
        } else if (text.startsWith("Воспользуйтесь этой")) {
            sendMessage.setReplyMarkup(managerApproveButtons.getManagerInlineApproveMarkup());
        } else if (text.startsWith("Оставайтесь на")) {
            sendMessage.setReplyMarkup(mainMenuButton.getMainMenuKeyboard());
        }

        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
