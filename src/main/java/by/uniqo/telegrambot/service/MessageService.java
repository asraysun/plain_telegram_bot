package by.uniqo.telegrambot.service;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.InlineKeyboard.*;
import by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief.*;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.AdminMenuButton;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButton;
import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButtonForAdditionMenu;
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
    AdminMenuButton adminMenuButton;
    @Autowired
    FindByButtons findByButtons;
    @Autowired
    ButtonsForFirstQuestion buttonsForFirstQuestion;
    @Autowired
    ButtonsForSecondQuestion buttonsForSecondQuestion;
    @Autowired
    ButtonsForThirdQuestion buttonsForThirdQuestion;
    @Autowired
    ButtonsForFourthQuestion buttonsForFourthQuestion;
    @Autowired
    ButtonsForFiveQuestion buttonsForFiveQuestion;
    @Autowired
    ButtonsForSixthQuestion buttonsForSixthQuestion;
    @Autowired
    ButtonsForSeventhQuestion buttonsForSeventhQuestion;
    @Autowired
    ButtonsForEighthQuestion buttonsForEighthQuestion;


    public void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setParseMode("HTML");
        sendMessage.setText(text);
        if(message.getFrom().getId() == 1307084432 || message.getFrom().getId() == 764602851) {
//        if(message.getFrom().getId() == 764602851) {
            sendMessage.setReplyMarkup(adminMenuButton.getAdminMenuKeyboard());
        } else sendMessage.setReplyMarkup(mainMenuButton.getMainMenuKeyboard());
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
//    public void sendMessageWithAdditionMenu(Message message, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setParseMode("HTML");
//        sendMessage.setText(text);
//        sendMessage.setReplyMarkup(mainMenuButtonForAdditionMenu.getAdditionMenuKeyboard());
//        try {
//            telegramBot.execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }

    public void sendMessageWithCallBackQuery(Message message, String text) {
        System.out.println(message);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        System.out.println(message.getChatId());
        sendMessage.setText(text);
        if (text.contains("Каждый бот")) {
            sendMessage.setReplyMarkup(step1buttons.getButtonsMarkupStep1());
        } else if (text.startsWith("Выберите тип навыка бота")) {
            sendMessage.setReplyMarkup(priceButtons.getGenderButtonsMarkup());
        } else if (text.startsWith("Укажите кол")) {
            sendMessage.setReplyMarkup(numberOfEmployeesButtons.getNumberOfEmployeesButtonsMarkup());
        } else if (text.startsWith("Поделиться кон")) {
            sendMessage.setReplyMarkup(mainMenuButtonForAdditionMenu.getAdditionMenuKeyboard());
        } else if (text.startsWith("Воспользуйтесь этой")) {
            sendMessage.setReplyMarkup(managerApproveButtons.getManagerInlineApproveMarkup());
        } else if (text.startsWith("Оставайтесь на")) {
            sendMessage.setReplyMarkup(mainMenuButton.getMainMenuKeyboard());
        } else if (text.startsWith("Выберите способ")) {
            sendMessage.setReplyMarkup(findByButtons.getFindByButtonsMarkup());
        } else if (text.startsWith("Какая у Вас сфера бизнеса?")) {
            sendMessage.setReplyMarkup(buttonsForFirstQuestion.getButtonsForFirstQuestionMarkup());
        } else if (text.startsWith("Используете ли Вы соцсети и мессенджеры в своем бизнесе?")) {
            sendMessage.setReplyMarkup(buttonsForSecondQuestion.getButtonsForSecondQuestionMarkup());
        } else if (text.startsWith("Сколько менеджеров в Вашей компании занимаются общением с клиентами?")) {
            sendMessage.setReplyMarkup(buttonsForThirdQuestion.getButtonsForThirdQuestionMarkup());
        } else if (text.startsWith("Какой бюджет на интернет-рекламу Вы тратите ежемесячно?")) {
            sendMessage.setReplyMarkup(buttonsForFourthQuestion.getButtonsForFourthQuestionMarkup());
        } else if (text.startsWith("Какие задачи будет выполнять чат-бот?")) {
            sendMessage.setReplyMarkup(buttonsForFiveQuestion.getButtonsForFiveQuestionMarkup());
        } else if (text.startsWith("Можете ли Вы дать tripwire?")) {
            sendMessage.setReplyMarkup(buttonsForSixthQuestion.getButtonsForSixQuestionMarkup());
        } else if (text.startsWith("Будет ли необходимость принимать оплату напрямую через бота?")) {
            sendMessage.setReplyMarkup(buttonsForSeventhQuestion.getButtonsForSeventhQuestionMarkup());
        } else if (text.startsWith("Есть ли необходимость в интеграции с CRM-системой или иными сервисами?")) {
            sendMessage.setReplyMarkup(buttonsForEighthQuestion.getButtonsForEighthQuestionMarkup());
        }

        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
