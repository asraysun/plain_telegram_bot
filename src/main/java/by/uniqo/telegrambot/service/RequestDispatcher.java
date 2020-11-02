package by.uniqo.telegrambot.service;


import by.uniqo.telegrambot.buttons.InlineKeyboard.PriceButtons;
import by.uniqo.telegrambot.enums.BotCommand;
import by.uniqo.telegrambot.model.TransferDTO;
import by.uniqo.telegrambot.processor.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
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
    PriceQuestionChainStep4Processor priceQuestionChainStep4Processor;
    //    @Autowired
//    UserProfileDataService userProfileDataService; // TODO теперь инфа сохраняется в БД, подключить её и переписать методы, которые раньше сохраняли инфу в бин UserProfileData 27.10.2020
    @Autowired
    PhoneErrorProcessor phoneErrorProcessor;
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    TransferDTO transferDTO;
    @Autowired
    SayThanksProcessor sayThanksProcessor;
    @Autowired
    NewUpdatesProcessor newUpdatesProcessor;
    @Autowired
    ManagerAnswerProcessor managerAnswerProcessor;

    public void dispatch(Update update) { // TODO добавить проверку на ID для админа
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
        if (update.hasMessage()) {
            if (update.getMessage().hasContact()) {
                return BotCommand.SAYTHANKS;
            }
            Message message = update.getMessage();
            if (transferDTO.getId() == null) {
                transferDTO.setChatId(message.getChat().getId());
                transferDTO.setId(message.getFrom().getId().longValue()); // TODO теперь инфа сохраняется в БД, подключить userProfileRepository 27-10-2020
                transferDTO.setUsername(message.getFrom().getUserName());
                transferDTO.setFirstname(message.getFrom().getFirstName());
                transferDTO.setLastname(message.getFrom().getLastName());
            }
            if (!transferDTO.getId().equals(update.getMessage().getFrom().getId().longValue())) {
                transferDTO.setChatId(message.getChat().getId());
                transferDTO.setId(message.getFrom().getId().longValue()); // TODO теперь инфа сохраняется в БД, подключить userProfileRepository 27-10-2020
                transferDTO.setUsername(message.getFrom().getUserName());
                transferDTO.setFirstname(message.getFrom().getFirstName());
                transferDTO.setLastname(message.getFrom().getLastName());
            }
            System.out.println(message.getChatId());
            if (message.hasText()) {
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
                    transferDTO.setBotCommand(BotCommand.PRICE.name());
                    return BotCommand.PRICE;
                } else if (msgText.startsWith(BotCommand.FAQ.getCommand())) {
                    return BotCommand.FAQ;
                } else if (msgText.startsWith(BotCommand.TELLMEMORE.getCommand())) {
                    transferDTO.setBotCommand(BotCommand.TELLMEMORE.name());
                    return BotCommand.TELLMEMORE;
                } else if (msgText.startsWith(BotCommand.MANAGER.getCommand())) {
                    return BotCommand.MANAGER;
                } else if (msgText.startsWith("Нет")) {
                    return BotCommand.NEWUPDATES;
                } else if (msgText.startsWith(BotCommand.ABOUTOURBOT.getCommand())) {
                    return BotCommand.ABOUTOURBOT;
                } else if (msgText.length() >= 7) {
                    transferDTO.setText(message.getText());
                    transferDTO.setDate(message.getDate());
                    return BotCommand.PRICEQUESTIONCHAINSTEP4;
                } else if (msgText.length() < 7) {
                    return BotCommand.SENDPHONEERROR;
                }
            }
        } else if (update.hasCallbackQuery()) { //TODO добавить обработку кнопок админа
            CallbackQuery buttonQuery = update.getCallbackQuery();
//            System.out.println(update.getCallbackQuery().getMessage().hasContact());
            transferDTO.setDate(buttonQuery.getMessage().getDate());
            if (buttonQuery.getData().equals("buttonVar1") ||
                    buttonQuery.getData().equals("buttonVar2") ||
                    buttonQuery.getData().equals("buttonVar3")) {
                transferDTO.setTypeOfBot(localeMessageService.getMessage("button." + buttonQuery.getData()));
                return BotCommand.PRICEQUESTIONCHAINSTEP2;
            } else if (buttonQuery.getData().equals("buttonSetPrice")) {
                return BotCommand.PRICEQUESTIONCHAINSTEP1;
            } else if (buttonQuery.getData().equals("buttonManagerCallBack")) {
                return BotCommand.MANAGERANSWER;
            } else if (buttonQuery.getData().equals("buttonStep1") || buttonQuery.getData().equals("buttonStep2") ||
                    buttonQuery.getData().equals("buttonStep3") || buttonQuery.getData().equals("buttonStep4")) {
                transferDTO.setNumberOfEmployees(localeMessageService.getMessage("button." + buttonQuery.getData()));
                return BotCommand.PRICEQUESTIONCHAINSTEP3;
            } else return BotCommand.PRICEQUESTIONCHAIN;
        }
        return BotCommand.NONE;
    }
}
