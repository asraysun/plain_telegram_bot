package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.service.RequestDispatcher;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminSendClientsListProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    RequestDispatcher requestDispatcher;

    Integer currentClient = 0;
    Integer nextClient = 1;

    public Integer getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Integer currentClient) {
        this.currentClient = currentClient;
    }

    public Integer getNextClient() {
        return nextClient;
    }

    public void setNextClient(Integer nextClient) {
        this.nextClient = nextClient;
    }

    //    764602851 - id в телеге Антона
    //        1307084432 - id Nastya
    @Override
    public String run() {
        List<UserProfileData> users = userProfileRepository.findAll();
        SendMessage send = new SendMessage();

        send.setChatId(1307084432L);
        users.get(currentClient);
        users.get(nextClient);
        send.setText(users.get(currentClient).getId().toString() + " " + users.get(currentClient).getFirstname()
                + "\n" + users.get(nextClient).getId().toString() + " " + users.get(nextClient).getFirstname());
        send.setReplyMarkup(getClientsByNumbers());
        try {
            telegramBot.execute(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return localeMessageService.getMessage("reply.clientsList", null, localeMessageService.getLocale());
    }

    public InlineKeyboardMarkup getClientsByNumbers() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<UserProfileData> users = userProfileRepository.findAll();

        InlineKeyboardButton buttonNextClient = new InlineKeyboardButton().setText("Next");
        InlineKeyboardButton buttonPreviousClient = new InlineKeyboardButton().setText("Previous");
        InlineKeyboardButton buttonFirst = new InlineKeyboardButton().setText(users.get(currentClient).getId().toString());
        InlineKeyboardButton buttonSecond = new InlineKeyboardButton().setText(users.get(nextClient).getId().toString());

        //Every button must have callBackData, or else not work !
        buttonNextClient.setCallbackData("buttonNextClient");
        buttonPreviousClient.setCallbackData("buttonPreviousClient");
        buttonFirst.setCallbackData("buttonFirst");
        buttonSecond.setCallbackData("buttonSecond");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(buttonPreviousClient);
        keyboardButtonsRow1.add(buttonFirst);
        keyboardButtonsRow1.add(buttonSecond);
        keyboardButtonsRow1.add(buttonNextClient);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup createButton(String button) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonNextClient = new InlineKeyboardButton().setText(button);

        buttonNextClient.setCallbackData("button");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(buttonNextClient);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
