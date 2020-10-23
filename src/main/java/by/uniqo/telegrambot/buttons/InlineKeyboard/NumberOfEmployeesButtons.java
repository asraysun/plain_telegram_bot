package by.uniqo.telegrambot.buttons.InlineKeyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumberOfEmployeesButtons extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getNumberOfEmployeesButtonsMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonStep1 = new InlineKeyboardButton().setText("1-5");
        InlineKeyboardButton buttonStep2 = new InlineKeyboardButton().setText("5-10");
        InlineKeyboardButton buttonStep3 = new InlineKeyboardButton().setText("10-50");
        InlineKeyboardButton buttonStep4 = new InlineKeyboardButton().setText("50+");

        //Every button must have callBackData, or else not work !
        buttonStep1.setCallbackData("buttonStep1");
        buttonStep2.setCallbackData("buttonStep2");
        buttonStep3.setCallbackData("buttonStep3");
        buttonStep4.setCallbackData("buttonStep4");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(buttonStep1);
        keyboardButtonsRow1.add(buttonStep2);
        keyboardButtonsRow1.add(buttonStep3);
        keyboardButtonsRow1.add(buttonStep4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

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
