package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class buttonsForSixthQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getFindByButtonsMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerTwentyEight = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton answerTwentyNine = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton answerThirty = new InlineKeyboardButton().setText("3");


        //Every button must have callBackData, or else not work !
        answerThirty.setCallbackData("answerThirty");
        answerTwentyEight.setCallbackData("answerTwentyEight");
        answerTwentyNine.setCallbackData("answerTwentyNine");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerTwentyEight);
        keyboardButtonsRow1.add(answerTwentyNine);
        keyboardButtonsRow1.add(answerThirty);


        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }

    private AnswerCallbackQuery sendAnswerCallbackQuery(String text, boolean alert, CallbackQuery callbackquery) {
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setCallbackQueryId(callbackquery.getId());
        answerCallbackQuery.setShowAlert(alert);
        answerCallbackQuery.setText(text);
        return answerCallbackQuery;
    }
}
