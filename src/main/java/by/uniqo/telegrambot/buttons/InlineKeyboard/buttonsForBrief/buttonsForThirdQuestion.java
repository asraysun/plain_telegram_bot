package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class buttonsForThirdQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getFindByButtonsMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerSeventeen = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton buttonStep1 = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton buttonStep2 = new InlineKeyboardButton().setText("3");
        InlineKeyboardButton buttonStep3 = new InlineKeyboardButton().setText("4");
        InlineKeyboardButton buttonStep4 = new InlineKeyboardButton().setText("5");


        //Every button must have callBackData, or else not work !
        answerSeventeen.setCallbackData("answerSeventeen");
        buttonStep1.setCallbackData("buttonStep1");
        buttonStep2.setCallbackData("buttonStep2");
        buttonStep3.setCallbackData("buttonStep3");
        buttonStep4.setCallbackData("buttonStep4");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerSeventeen);
        keyboardButtonsRow1.add(buttonStep1);
        keyboardButtonsRow1.add(buttonStep2);
        keyboardButtonsRow1.add(buttonStep3);
        keyboardButtonsRow1.add(buttonStep4);


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
