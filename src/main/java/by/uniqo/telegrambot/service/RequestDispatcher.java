package by.uniqo.telegrambot.service;


import by.uniqo.telegrambot.buttons.ReplyKeyboard.ReplyButtonProcessor;
import by.uniqo.telegrambot.cache.UserDataCache;
import by.uniqo.telegrambot.enums.BotCommand;
import by.uniqo.telegrambot.processor.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

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
    ReplyButtonProcessor replyButtonProcessor;
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

    public void dispatch(Update update) {
        switch (getCommand(update)) {
            case HELP:
                messageService.sendMessage(update.getMessage(), helpProcessor.run());
                break;
            case START:
                messageService.sendMessage(update.getMessage(), startProcessor.run());
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
                messageService.sendMessage(update.getMessage(), priceProcessor.run());
                break;
           case FAQ:
                messageService.sendMessage(update.getMessage(), faqProcessor.run());
                break;
           case TELLMEMORE:
                messageService.sendMessage(update.getMessage(), tellMeMoreProcessor.run());
                break;
           case MANAGER:
                messageService.sendMessage(update.getMessage(), managerProcessor.run());
                break;

        }
    }

    public void dispatchBotState(Update update, UserDataCache userDataCache) {

    }

    private BotCommand getCommand(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                String msgText = message.getText();
                if (msgText.startsWith(BotCommand.HELP.getCommand())) {
                    return BotCommand.HELP;
                } else if (msgText.startsWith(BotCommand.START.getCommand())) {
                    return BotCommand.START;
                } else if (msgText.startsWith(BotCommand.SETTING.getCommand())) {
                    return BotCommand.SETTING;
                } else if (msgText.startsWith(BotCommand.SEVEN.getCommand())) {
                    return BotCommand.SEVEN;
                } else if (msgText.startsWith(BotCommand.ABOUTBOT.getCommand())) {
                    return BotCommand.ABOUTBOT;
                } else if (msgText.startsWith(BotCommand.SCOPEOFAPP.getCommand())) {
                    return BotCommand.SCOPEOFAPP;
                } else if (msgText.startsWith(BotCommand.PRICE.getCommand())) {
                    return BotCommand.PRICE;
                } else if (msgText.startsWith(BotCommand.FAQ.getCommand())) {
                    return BotCommand.FAQ;
                } else if (msgText.startsWith(BotCommand.TELLMEMORE.getCommand())) {
                    return BotCommand.TELLMEMORE;
                } else if (msgText.startsWith(BotCommand.MANAGER.getCommand())) {
                    return BotCommand.MANAGER;
                }
            }
        }
        return BotCommand.NONE;
    }
}
