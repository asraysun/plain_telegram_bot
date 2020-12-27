package by.uniqo.telegrambot.service;


import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.buttons.InlineKeyboard.PriceButtons;
import by.uniqo.telegrambot.cache.DataCache;
import by.uniqo.telegrambot.enums.BotCommand;
import by.uniqo.telegrambot.enums.BotState;
import by.uniqo.telegrambot.model.TextHistorySendedToClients;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.processor.*;
import by.uniqo.telegrambot.processor.findBy.*;
import by.uniqo.telegrambot.processor.mainmenu.AboutBotProcessor;
import by.uniqo.telegrambot.processor.mainmenu.AboutOurProcessor;
import by.uniqo.telegrambot.processor.mainmenu.ScopeOfAppProcessor;
import by.uniqo.telegrambot.processor.mainmenu.TellMeMoreProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.HelpProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.SendProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.SettingsProcessor;
import by.uniqo.telegrambot.processor.mainmenu.defaultProcessors.SevenProcessor;
import by.uniqo.telegrambot.processor.mainmenu.errors.NoneProcessor;
import by.uniqo.telegrambot.processor.mainmenu.errors.PhoneErrorProcessor;
import by.uniqo.telegrambot.processor.mainmenu.pricebutton.*;
import by.uniqo.telegrambot.repository.TextHistorySendedToClientsRepository;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
    SendMessageToClientsProcessor sendMessageToClientsProcessor;
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
    FindByNameProcessor findByNameProcessor;
    @Autowired
    FindByIdProcessor findByIdProcessor;
    @Autowired
    FindByPhoneNumberProcessor findByPhoneNumberProcessor;
    @Autowired
    FindByTimeStampProcessor findByTimeStampProcessor;
    @Autowired
    ManagerAnswerProcessor managerAnswerProcessor;
    @Autowired
    AdminSendClientsListProcessor adminSendClientsListProcessor;
    @Autowired
    TextHistorySendedToClientsRepository textHistorySendedToClientsRepository;
    @Autowired
    AdminStartProcessor adminStartProcessor;
    @Autowired
    MessageToOneClientProcessor messageToOneClientProcessor;
    @Autowired
    SendProcessor sendProcessor;
    @Autowired
    FinallySendThisMessageProcessor finallySendThisMessageProcessor;
    @Autowired
    FindByInputMessageProcessor findByInputMessageProcessor;
    @Autowired
    SendMessageToClientStep2Processor sendMessageToClientStep2Processor;
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    DataCache dataCache;

    public void dispatch(Update update) {// TODO добавить проверку на ID для админа

        switch (getCommand(update)) {
            case HELP:
                messageService.sendMessage(update.getMessage(), helpProcessor.run());
                break;
            case SEND:
//                if (update.getMessage().getFrom().getId() == 764602851) {
                if (update.getMessage().getFrom().getId() == 1307084432) {
                    dataCache.setSetStatus("hold");
                }
                messageService.sendMessage(update.getMessage(), sendProcessor.run());
                break;
            case START:
//                if (update.getMessage().getFrom().getId() == 764602851 ||
//                        update.getMessage().getFrom().getId() == 1307084432) {
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
//                deleteMessage();
                messageService.sendMessage(update.getMessage(), adminSendClientsListProcessor.run());
                break;
            case FINDBY:
                messageService.sendMessageWithCallBackQuery(update.getMessage(), findByProcessor.run());
                break;
            case FINDBYNAME:
                messageService.sendMessage(update.getMessage(), findByNameProcessor.run());
                break;
            case FINDBYID:
                messageService.sendMessage(update.getMessage(), findByIdProcessor.run());
                break;
            case FINDBYPHONENUMBER:
                messageService.sendMessage(update.getMessage(), findByPhoneNumberProcessor.run());
                break;
            case FINDBYTIMESTAMP:
                messageService.sendMessage(update.getMessage(), findByTimeStampProcessor.run());
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
//            case SENDDOCUMENT:
//                messageService.sendMessage(update.getMessage(), sendMessageProcessor.run());
//                break;
            case SENDMESSAGETOCLIENTS:
                messageService.sendMessage(update.getMessage(), sendMessageToClientsProcessor.run());
                break;
            case MSGONECLIENT:
//                if (update.getMessage().getFrom().getId() == 764602851 ||
                if (
                        update.getMessage().getFrom().getId() == 1307084432) {
                    dataCache.setFlag("input");
                    messageService.sendMessage(update.getMessage(), messageToOneClientProcessor.run());
                }
                break;
            case SAYTHANKS:
                messageService.sendMessage(update.getMessage(), sayThanksProcessor.run());
                break;
            case SENDONEMESSAGE:
//                if (update.getMessage().getFrom().getId() == 764602851 ||
                if (
                        update.getMessage().getFrom().getId() == 1307084432) {
                    dataCache.setFlag("IdSet");
                    messageService.sendMessage(update.getMessage(), sendMessageToClientStep2Processor.run());
                }
                break;
            case FINALLYSENDMESSAGETOCLIENT:
//                if (update.getMessage().getFrom().getId() == 764602851 ||
                if (
                        update.getMessage().getFrom().getId() == 1307084432) {
                    dataCache.setFlag("idInputOk");
                    dataCache.setUserId(0L);
                    messageService.sendMessage(update.getMessage(), finallySendThisMessageProcessor.run());
                }
                break;
            case MANAGERANSWER:
                CallbackQuery send4 = update.getCallbackQuery();
                messageService.sendMessage(send4.getMessage(), managerAnswerProcessor.run());
                break;
            case SENDPHONEERROR:
                messageService.sendMessage(update.getMessage(), phoneErrorProcessor.run());
                break;
            case FINDBYINPUTMSG:
                messageService.sendMessage(update.getMessage(), findByInputMessageProcessor.run());
                break;

        }
    }

    @SneakyThrows
    private BotCommand getCommand(Update update) {
        UserProfileData userProfileData = null;
        TextHistorySendedToClients textHistorySendedToClients = null;
//        saveMessage(update.getMessage());
        if (userProfileRepository.findUserProfileDataByChatId(getUserId(update).longValue()) != null) {
            userProfileData = userProfileRepository.findUserProfileDataByChatId(getUserId(update).longValue());
            if (update.hasMessage()) {
                System.out.println("have message" + update.getMessage().getMessageId());
                if (update.getMessage().hasContact()) {  // TODO из-за этой проверки возвращается после нажатия незахендленной кнопки текст - "Спасибо за ваш заказ..."
                    return BotCommand.SAYTHANKS;
                }
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
                    } else if (msgText.startsWith("Отправить сообщение клиенту")) {
                        return BotCommand.SEND;
                    } else if (msgText.equals("Список клиентов")) {
                        return BotCommand.SENDCLIENTSLIST;
                    } else if (dataCache.getFlag().equals("input")) {
                        Long numberUserId = Long.parseLong(update.getMessage().getText());
                        getClient(numberUserId);
                        return BotCommand.SENDONEMESSAGE;
                    } else if (dataCache.getFlag().equals("IdSet")) {
                        sendMessageToOneClient(update.getMessage().getText());
                        return BotCommand.FINALLYSENDMESSAGETOCLIENT;
                    } else if (dataCache.getSetStatus().equals("hold")) {
                        sendMessageForClients(update.getMessage().getText());
//                        if (update.getMessage().getFrom().getId() == 1307084432) {
//                            dataCache.setSetStatus("hold");
//                        }
//                        if(dataCache.getSetStatus().equals("hold")){
//
//                        }
                        dataCache.setSetStatus("stop");
                        return BotCommand.SENDMESSAGETOCLIENTS;
                    } else if (msgText.startsWith(BotCommand.SEVEN.getCommand())) {
                        return BotCommand.SEVEN;
                    } else if (msgText.equals("Сообщение одному клиенту")) {
                        return BotCommand.MSGONECLIENT;
                    } else if (msgText.startsWith(BotCommand.SEND.getCommand())) {
                        return BotCommand.SEND;
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
                    }
//                    else if (msgText.length() >= 7) {
//                        userProfileData.setText(message.getText());
//                        userProfileData.setDate(message.getDate());
//                        userProfileRepository.save(userProfileData);
//                        return BotCommand.PRICEQUESTIONCHAINSTEP4;
//                    } else if (msgText.length() < 7) {
//                        return BotCommand.SENDPHONEERROR;
//                    }
                }
            } else if (update.hasCallbackQuery()) { //TODO добавить обработку кнопок админа
                System.out.println("has callback" + update.getCallbackQuery().getMessage().getMessageId());
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
                } else if (buttonQuery.getData().equals("buttonFindByName")) {
                    return BotCommand.FINDBYNAME;
                } else if (buttonQuery.getData().equals("buttonFindByID")) {
                    return BotCommand.FINDBYID;
                } else if (buttonQuery.getData().equals("buttonFindByPhoneNumber")) {
                    return BotCommand.FINDBYPHONENUMBER;
                } else if (buttonQuery.getData().equals("buttonFindByDate")) {
                    return BotCommand.FINDBYTIMESTAMP;
                } else if (buttonQuery.getData().equals("buttonNextClient")) {
                        adminSendClientsListProcessor.setCurrentClient(adminSendClientsListProcessor.getCurrentClient() + 2);
                        adminSendClientsListProcessor.setNextClient(adminSendClientsListProcessor.getNextClient() + 2);
                    return BotCommand.SENDCLIENTSLIST;
                } else if (buttonQuery.getData().equals("buttonPreviousClient")) {
                    if (adminSendClientsListProcessor.getCurrentClient().equals(0)) {
                        adminSendClientsListProcessor.setCurrentClient(0);
                        adminSendClientsListProcessor.setNextClient(1);
                    } else {
                        adminSendClientsListProcessor.setCurrentClient(adminSendClientsListProcessor.getCurrentClient() - 2);
                        adminSendClientsListProcessor.setNextClient(adminSendClientsListProcessor.getNextClient() - 2);
                    }
                    return BotCommand.SENDCLIENTSLIST;
                } else if (buttonQuery.getData().equals("buttonFirst")) {
                    List<UserProfileData> users = userProfileRepository.findAll();
                    SendMessage send = new SendMessage();
                    send.setText(users.get(adminSendClientsListProcessor.getCurrentClient()).toString());
                    send.setChatId(1307084432L);
                    try {
                        telegramBot.execute(send);
                    }catch (Exception e) {

                    }
                    return BotCommand.SENDCLIENTSLIST;
                } else if (buttonQuery.getData().equals("buttonSecond")) {
                    List<UserProfileData> users = userProfileRepository.findAll();

                    SendMessage send = new SendMessage();
                    send.setText(users.get(adminSendClientsListProcessor.getNextClient()).toString());
                    send.setChatId(1307084432L);
                    try {
                        telegramBot.execute(send);
                    } catch (Exception e) {

                    }
                    return BotCommand.SENDCLIENTSLIST;
                }
                return BotCommand.PRICEQUESTIONCHAIN;
            }
        } else {
            saveUser(update.getMessage());
            return BotCommand.START;
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

//    private void saveMessage(Message message) {
//        if(message.getChatId()==null) {
//
//        }
//        TextHistorySendedToClients textHistorySendedToClients = TextHistorySendedToClients.builder()
//                .chatId(message.getChatId())
//                .timestamp(message.getDate().toString())
////                .audio(message.getAudio().getFileId())
//                .text(message.getText())
//                .messageId(message.getMessageId().longValue())
//                .build();
//        if (textHistorySendedToClientsRepository.findTextHistorySendedToClientsByMessageIdAndAndChatId(message.getMessageId().longValue(), message.getChatId()) == null) {
//            textHistorySendedToClientsRepository.save(textHistorySendedToClients);
//        }
//    }
//    private void deleteMessage() {
//        DeleteMessage deleteMessage = new DeleteMessage();
//        deleteMessage.setChatId(956524755L);
//        deleteMessage.setMessageId(8027);
//        try {
//            telegramBot.execute(deleteMessage);
////            telegramBot.execute(send1);
////            telegramBot.execute(sendContact);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }

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

    private void sendMessageForClients(String text) {
        List<UserProfileData> users = userProfileRepository.findAll();
        for (UserProfileData user : users) {
            SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
            send.setChatId(user.getChatId());
//        send1.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
            send.setText(text);
//        send1.setText("номер телефона: " + userProfileData.toString());
            try {
                telegramBot.execute(send);
//            telegramBot.execute(send1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessageToOneClient(String text) {
        SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
        send.setChatId(dataCache.getUserId());
//        send1.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
        send.setText(text);
//        send1.setText("номер телефона: " + userProfileData.toString());
        try {
            telegramBot.execute(send);
//            telegramBot.execute(send1);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void getClient(Long id) {
        UserProfileData user = userProfileRepository.getUserNameById(id);
        dataCache.setUserId(user.getChatId());
    }
}
