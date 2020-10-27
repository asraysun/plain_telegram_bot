package by.uniqo.telegrambot.service;


import by.uniqo.telegrambot.buttons.InlineKeyboard.PriceButtons;
import by.uniqo.telegrambot.enums.BotCommand;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.processor.*;
//import by.uniqo.telegrambot.repo.UserProfileRepo;
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
    @Autowired
    UserProfileDataService userProfileDataService; // TODO теперь инфа сохраняется в БД, подключить её и переписать методы, которые раньше сохраняли инфу в бин UserProfileData 27.10.2020
    @Autowired
    PhoneErrorProcessor phoneErrorProcessor;
    @Autowired
    LocaleMessageService localeMessageService;
    UserProfileData userProfileData = new UserProfileData();

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
            case FAQ:
                messageService.sendMessage(update.getMessage(), faqProcessor.run());
                break;
            case TELLMEMORE:
                messageService.sendMessage(update.getMessage(), tellMeMoreProcessor.run());
                break;
            case MANAGER:
                messageService.sendMessage(update.getMessage(), managerProcessor.run());
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
            case SENDPHONEERROR:
                messageService.sendMessage(update.getMessage(), phoneErrorProcessor.run());
                break;

        }
    }

    public void dispatchBotState(UserProfileData userDataCache) {

    }

    private BotCommand getCommand(Update update) {

        if(userProfileDataService.findAll() == null) {
            UserProfileData userProfileData = new UserProfileData();
        } else if (userProfileDataService.findAll()!=null) {
            userProfileDataService.findById(userProfileData.getId());
        }

        if (update.hasMessage()) {
            Message message = update.getMessage();
            userProfileData.setId(message.getChat().getId()); // TODO теперь инфа сохраняется в БД, подключить userProfileRepository 27-10-2020
            userProfileData.setUsername(message.getFrom().getUserName());
            userProfileData.setFirstname(message.getFrom().getFirstName());
            userProfileData.setLastname(message.getFrom().getLastName());
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
                    userProfileData.setBotCommand(BotCommand.PRICE.name());
                    return BotCommand.PRICE;
                } else if (msgText.startsWith(BotCommand.FAQ.getCommand())) {
                    return BotCommand.FAQ;
                } else if (msgText.startsWith(BotCommand.TELLMEMORE.getCommand())) {
                    userProfileData.setBotCommand(BotCommand.TELLMEMORE.name());
                    return BotCommand.TELLMEMORE;
                } else if (msgText.startsWith(BotCommand.MANAGER.getCommand())) {
                    return BotCommand.MANAGER;
                } else if (msgText.startsWith(BotCommand.ABOUTOURBOT.getCommand())) {
                    return BotCommand.ABOUTOURBOT;
                } else if (msgText.length() >= 7) {
                    userProfileData.setText(message.getText());
                    userProfileData.setDate(message.getDate());
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
                userProfileData.setTypeOfBot(localeMessageService.getMessage("button." +buttonQuery.getData()));
                return BotCommand.PRICEQUESTIONCHAINSTEP2;
            } else if (buttonQuery.getData().equals("buttonSetPrice")) {
                return BotCommand.PRICEQUESTIONCHAINSTEP1;
            } else if (buttonQuery.getData().equals("buttonStep1") || buttonQuery.getData().equals("buttonStep2") ||
                    buttonQuery.getData().equals("buttonStep3") || buttonQuery.getData().equals("buttonStep4")) {
                userProfileData.setNumberOfEmployees(localeMessageService.getMessage("button." +buttonQuery.getData()));
                return BotCommand.PRICEQUESTIONCHAINSTEP3;
            } else return BotCommand.PRICEQUESTIONCHAIN;
        }
        return BotCommand.NONE;
    }
}
