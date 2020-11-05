package by.uniqo.telegrambot.service;


import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.InlineKeyboard.PriceButtons;
import by.uniqo.telegrambot.enums.BotCommand;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.processor.*;
import by.uniqo.telegrambot.processor.mainmenu.AboutBotProcessor;
import by.uniqo.telegrambot.processor.mainmenu.AboutOurProcessor;
import by.uniqo.telegrambot.processor.mainmenu.ScopeOfAppProcessor;
import by.uniqo.telegrambot.processor.mainmenu.TellMeMoreProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.HelpProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.SettingsProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.SevenProcessor;
import by.uniqo.telegrambot.processor.mainmenu.errors.NoneProcessor;
import by.uniqo.telegrambot.processor.mainmenu.errors.PhoneErrorProcessor;
import by.uniqo.telegrambot.processor.mainmenu.pricebutton.*;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.PrintStream;
import java.util.List;


@Slf4j
@Service
public class RequestDispatcher {

    @Autowired
    MessageService messageService;
    @Autowired
    HelpProcessor helpProcessor;
    @Autowired
    SettingsProcessor settingsProcessor;
    @Autowired
    StartProcessor startProcessor;
    @Autowired
    NoneProcessor noneProcessor;
    @Autowired
    SevenProcessor sevenProcessor;
    @Autowired
    AboutBotProcessor aboutBotProcessor;
    @Autowired
    FAQProcessor faqProcessor;
    @Autowired
    ManagerProcessor managerProcessor;
    @Autowired
    PriceProcessor priceProcessor;
    @Autowired
    ScopeOfAppProcessor scopeOfAppProcessor;
    @Autowired
    TellMeMoreProcessor tellMeMoreProcessor;
    @Autowired
    AboutOurProcessor aboutOurProcessor;
    @Autowired
    PriceButtons priceButtons;
    @Autowired
    PriceQuestionChainProcessor priceQuestionChainProcessor;
    @Autowired
    PriceQuestionChainStep1Processor priceQuestionChainStep1Processor;
    @Autowired
    PriceQuestionChainStep2Processor priceQuestionChainStep2Processor;
    @Autowired
    PriceQuestionChainStep3Processor priceQuestionChainStep3Processor;
    @Autowired
    SendDocumentProcessor sendDocumentProcessor;
    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    PriceQuestionChainStep4Processor priceQuestionChainStep4Processor;
    @Autowired
    PhoneErrorProcessor phoneErrorProcessor;
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    SayThanksProcessor sayThanksProcessor;
    @Autowired
    NewUpdatesProcessor newUpdatesProcessor;
    @Autowired
    FindByProcessor findByProcessor;
    @Autowired
    ManagerAnswerProcessor managerAnswerProcessor;
    @Autowired
    AdminSendMessageProcessor adminSendMessageProcessor;
    @Autowired
    AdminStartProcessor adminStartProcessor;
    @Autowired
    TelegramBot telegramBot;

    public void dispatch(Update update) { // TODO добавить проверку на ID для админа
        switch (getCommand(update)) {
            case HELP:
                messageService.sendMessage(update.getMessage(), helpProcessor.run());
                break;
            case START:
                if (update.getMessage().getFrom().getId() == 1307084432) {
                    messageService.sendMessage(update.getMessage(), adminStartProcessor.run());
                } else messageService.sendMessage(update.getMessage(), startProcessor.run());
                saveUser(update.getMessage());
                break;
            case SETTING:
                messageService.sendMessage(update.getMessage(), settingsProcessor.run());
                break;
            case SEVEN:
                messageService.sendMessage(update.getMessage(), sevenProcessor.run());
                break;
            case ABOUTBOT:
                messageService.sendMessage(update.getMessage(), aboutBotProcessor.run());
                break;
            case SCOPEOFAPP:
                messageService.sendMessage(update.getMessage(), scopeOfAppProcessor.run());
                break;
            case NONE:
                messageService.sendMessage(update.getMessage(), noneProcessor.run());
                break;
            case PRICE:
                messageService.sendMessageWithCallBackQuery(update.getMessage(), priceProcessor.run());
                break;
            case NEWUPDATES:
                messageService.sendMessageWithCallBackQuery(update.getMessage(), newUpdatesProcessor.run());
                break;
            case FAQ:
                messageService.sendMessage(update.getMessage(), faqProcessor.run());
                break;
            case TELLMEMORE:
                messageService.sendMessage(update.getMessage(), tellMeMoreProcessor.run());
                break;
            case MANAGER:
                messageService.sendMessageWithCallBackQuery(update.getMessage(), managerProcessor.run());
                break;
            case ABOUTOURBOT:
                messageService.sendMessage(update.getMessage(), aboutOurProcessor.run());
                break;
            case SENDCLIENTSLIST:
                List<UserProfileData> users = userProfileRepository.findAll();
                for (UserProfileData user : users) {
                    SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
                    send.setChatId(1307084432L);
//        send1.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
                    send.setText("номер телефона: " + user.toString());
//        send1.setText("номер телефона: " + userProfileData.toString());
                    try {
                        telegramBot.execute(send);
//            telegramBot.execute(send1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                messageService.sendMessage(update.getMessage(), adminSendMessageProcessor.run());
                break;
            case FINDBY:
                messageService.sendMessageWithCallBackQuery(update.getMessage(), findByProcessor.run());
                break;
            case PRICEQUESTIONCHAIN:
                messageService.sendMessage(update.getMessage(), priceQuestionChainProcessor.run());
                break;
            case PRICEQUESTIONCHAINSTEP1:
                CallbackQuery send = update.getCallbackQuery();
                messageService.sendMessageWithCallBackQuery(send.getMessage(), priceQuestionChainStep1Processor.run());
                break;
            case PRICEQUESTIONCHAINSTEP2:
                CallbackQuery send1 = update.getCallbackQuery();
                messageService.sendMessageWithCallBackQuery(send1.getMessage(), priceQuestionChainStep2Processor.run());
                break;
            case PRICEQUESTIONCHAINSTEP3:
                CallbackQuery send2 = update.getCallbackQuery();
                messageService.sendMessageWithCallBackQuery(send2.getMessage(), priceQuestionChainStep3Processor.run());
                break;
            case PRICEQUESTIONCHAINSTEP4:
                messageService.sendMessage(update.getMessage(), priceQuestionChainStep4Processor.run());
                break;
            case SENDDOCUMENT:
                messageService.sendMessage(update.getMessage(), sendDocumentProcessor.run());
                break;
            case SAYTHANKS:
                messageService.sendMessage(update.getMessage(), sayThanksProcessor.run());
                break;
            case MANAGERANSWER:
                CallbackQuery send4 = update.getCallbackQuery();
                messageService.sendMessage(send4.getMessage(), managerAnswerProcessor.run());
                break;
            case SENDPHONEERROR:
                messageService.sendMessage(update.getMessage(), phoneErrorProcessor.run());
                break;

        }
    }

    private BotCommand getCommand(Update update) {

        UserProfileData userProfileData = null;
        if (userProfileRepository.findUserProfileDataByChatId(getUserId(update).longValue()) != null) {
            userProfileData = userProfileRepository.findUserProfileDataByChatId(getUserId(update).longValue());
            if (update.hasMessage()) {
//                if (update.getMessage().hasContact()) {  // TODO из-за этой проверки возвращается после нажатия незахендленной кнопки текст - "Спасибо за ваш заказ..."
//                    return BotCommand.SAYTHANKS;
//                }
                Message message = update.getMessage();
                if (message.hasText()) {
                    String msgText = message.getText();
                    if (msgText.startsWith(BotCommand.HELP.getCommand())) {
                        return BotCommand.HELP;
                    } else if (msgText.startsWith(BotCommand.START.getCommand())) {
                        return BotCommand.START;
                    } else if (msgText.startsWith(BotCommand.SETTING.getCommand())) {
                        return BotCommand.SETTING;
                    } else if (msgText.startsWith("Поиск клиент")) {
                        return BotCommand.FINDBY;
                    } else if (msgText.equals("Список клиентов")) {
//                        List<UserProfileData> list =
//                        for (:
//                             ) {
//
//                        }

                        return BotCommand.SENDCLIENTSLIST;
                    } else if (msgText.startsWith(BotCommand.SEVEN.getCommand())) {
                        return BotCommand.SEVEN;
                    } else if (msgText.startsWith(BotCommand.ABOUTBOT.getCommand())) {
                        return BotCommand.ABOUTBOT;
                    } else if (msgText.startsWith(BotCommand.SCOPEOFAPP.getCommand())) {
                        return BotCommand.SCOPEOFAPP;
                    } else if (msgText.startsWith(BotCommand.PRICE.getCommand())) {
                        userProfileData.setBotCommand(BotCommand.PRICE.name());
                        userProfileRepository.save(userProfileData);
                        return BotCommand.PRICE;
                    } else if (msgText.startsWith(BotCommand.FAQ.getCommand())) {
                        return BotCommand.FAQ;
                    } else if (msgText.startsWith(BotCommand.TELLMEMORE.getCommand())) {
                        TellMeMoreProcessor.chatId = userProfileData.getChatId();
                        userProfileData.setBotCommand(BotCommand.TELLMEMORE.name());
                        userProfileRepository.save(userProfileData);
                        return BotCommand.TELLMEMORE;
                    } else if (msgText.startsWith(BotCommand.MANAGER.getCommand())) {
                        return BotCommand.MANAGER;
                    } else if (msgText.startsWith("Нет")) {
                        return BotCommand.NEWUPDATES;
                    } else if (msgText.startsWith(BotCommand.ABOUTOURBOT.getCommand())) {
                        return BotCommand.ABOUTOURBOT;
                    } else if (msgText.length() >= 7) {
                        userProfileData.setText(message.getText());
                        userProfileData.setDate(message.getDate());
                        userProfileRepository.save(userProfileData);
                        return BotCommand.PRICEQUESTIONCHAINSTEP4;
                    } else if (msgText.length() < 7) {
                        return BotCommand.SENDPHONEERROR;
                    }
                }
            } else if (update.hasCallbackQuery()) { //TODO добавить обработку кнопок админа
                CallbackQuery buttonQuery = update.getCallbackQuery();
                if (buttonQuery.getData().equals("buttonVar1") ||
                        buttonQuery.getData().equals("buttonVar2") ||
                        buttonQuery.getData().equals("buttonVar3")) {
                    userProfileData.setTypeOfBot(localeMessageService.getMessage("button." + buttonQuery.getData()));
                    userProfileRepository.save(userProfileData);
                    return BotCommand.PRICEQUESTIONCHAINSTEP2;
                } else if (buttonQuery.getData().equals("buttonSetPrice")) {
                    return BotCommand.PRICEQUESTIONCHAINSTEP1;
                } else if (buttonQuery.getData().equals("buttonManagerCallBack")) {
                    return BotCommand.MANAGERANSWER;
                } else if (buttonQuery.getData().equals("buttonStep1") || buttonQuery.getData().equals("buttonStep2") ||
                        buttonQuery.getData().equals("buttonStep3") || buttonQuery.getData().equals("buttonStep4")) {
                    TellMeMoreProcessor.chatId = userProfileData.getChatId();
                    userProfileData.setNumberOfEmployees(localeMessageService.getMessage("button." + buttonQuery.getData()));
                    userProfileRepository.save(userProfileData);
                    return BotCommand.PRICEQUESTIONCHAINSTEP3;
                } else return BotCommand.PRICEQUESTIONCHAIN;
            }
        } else {
            saveUser(update.getMessage());
            getCommand(update);
        }

        return BotCommand.NONE;
    }

    private void saveUser(Message message) {
        UserProfileData userProfileData = UserProfileData.builder()
                .firstname(message.getFrom().getFirstName())
                .username(message.getFrom().getUserName())
                .lastname(message.getFrom().getLastName())
                .chatId(message.getFrom().getId().longValue())
                .build();
        if (userProfileRepository.findUserProfileDataByChatId(message.getChatId()) == null) {
            userProfileRepository.save(userProfileData);
        }
    }

    private Integer getUserId(Update update) {
        int userId = 0;
        if (update.getEditedMessage() != null) {
            userId = update.getEditedMessage().getFrom().getId();
        } else if (update.getCallbackQuery() == null) {
            userId = update.getMessage().getFrom().getId();
        } else if (update.getMessage() == null) {
            userId = update.getCallbackQuery().getFrom().getId();
        }
        return userId;
    }
}
