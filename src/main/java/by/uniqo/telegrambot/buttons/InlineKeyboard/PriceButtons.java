package by.uniqo.telegrambot.buttons.InlineKeyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
@Component
public class PriceButtons extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getGenderButtonsMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonVar1 = new InlineKeyboardButton().setText("Отвечать на вопросы");
        InlineKeyboardButton buttonVar2 = new InlineKeyboardButton().setText("Продавать и отвечать на вопросы");
        InlineKeyboardButton buttonVar3 = new InlineKeyboardButton().setText("Эксклюзивная разработка под ваш бизнес");

        //Every button must have callBackData, or else not work !
        buttonVar1.setCallbackData("buttonVar1");
        buttonVar2.setCallbackData("buttonVar2");
        buttonVar3.setCallbackData("buttonVar3");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow1.add(buttonVar1);
        keyboardButtonsRow2.add(buttonVar2);
        keyboardButtonsRow3.add(buttonVar3);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }

//    private BotApiMethod<?> processCallbackQuery(CallbackQuery buttonQuery) {
//        final long chatId = buttonQuery.getMessage().getChatId();
//        final int userId = buttonQuery.getFrom().getId();
//        BotApiMethod<?> callBackAnswer = mainMenuService.getMainMenuMessage(chatId, "Воспользуйтесь главным меню");
//
//
//        //From Destiny choose buttons
//        if (buttonQuery.getData().equals("buttonYes")) {
//            callBackAnswer = new SendMessage(chatId, "Как тебя зовут ?");
//            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_AGE);
//        } else if (buttonQuery.getData().equals("buttonNo")) {
//            callBackAnswer = sendAnswerCallbackQuery("Возвращайся, когда будешь готов", false, buttonQuery);
//        } else if (buttonQuery.getData().equals("buttonIwillThink")) {
//            callBackAnswer = sendAnswerCallbackQuery("Данная кнопка не поддерживается", true, buttonQuery);
//        }
//
//        //From Gender choose buttons
//        else if (buttonQuery.getData().equals("buttonMan")) {
//            UserProfileData userProfileData = userDataCache.getUserProfileData(userId);
//            userProfileData.setGender("М");
//            userDataCache.saveUserProfileData(userId, userProfileData);
//            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_COLOR);
//            callBackAnswer = new SendMessage(chatId, "Твоя любимая цифра");
//        } else if (buttonQuery.getData().equals("buttonWoman")) {
//            UserProfileData userProfileData = userDataCache.getUserProfileData(userId);
//            userProfileData.setGender("Ж");
//            userDataCache.saveUserProfileData(userId, userProfileData);
//            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_COLOR);
//            callBackAnswer = new SendMessage(chatId, "Твоя любимая цифра");
//
//        } else {
//            userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_MAIN_MENU);
//        }
//
//
//        return callBackAnswer;
//
//
//    }


    private AnswerCallbackQuery sendAnswerCallbackQuery(String text, boolean alert, CallbackQuery callbackquery) {
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setCallbackQueryId(callbackquery.getId());
        answerCallbackQuery.setShowAlert(alert);
        answerCallbackQuery.setText(text);
        return answerCallbackQuery;
    }
}
