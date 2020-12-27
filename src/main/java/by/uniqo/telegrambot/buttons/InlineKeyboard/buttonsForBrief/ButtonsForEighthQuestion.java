package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonsForEighthQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getButtonsForEighthQuestionMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerYes = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton answerNo = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton answerStruggling = new InlineKeyboardButton().setText("3");


        //Every button must have callBackData, or else not work !
        answerYes.setCallbackData("answerFiftyEight");
        answerNo.setCallbackData("answerFiftyNine");
        answerStruggling.setCallbackData("answerSixty");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerYes);
        keyboardButtonsRow1.add(answerNo);
        keyboardButtonsRow1.add(answerStruggling);


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
