package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class buttonsForSecondQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getFindByButtonsMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerTen = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton answerEleven = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton answerTwelve = new InlineKeyboardButton().setText("3");
        InlineKeyboardButton answerThirteen = new InlineKeyboardButton().setText("4");
        InlineKeyboardButton answerFourteen = new InlineKeyboardButton().setText("5");
        InlineKeyboardButton answerFifteen = new InlineKeyboardButton().setText("6");
        InlineKeyboardButton answerSixteen = new InlineKeyboardButton().setText("7");


        //Every button must have callBackData, or else not work !
        answerTen.setCallbackData("answerTen");
        answerEleven.setCallbackData("answerEleven");
        answerTwelve.setCallbackData("answerTwelve");
        answerThirteen.setCallbackData("answerThirteen");
        answerFourteen.setCallbackData("answerFourteen");
        answerFifteen.setCallbackData("answerFifteen");
        answerSixteen.setCallbackData("answerSixteen");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerTen);
        keyboardButtonsRow1.add(answerEleven);
        keyboardButtonsRow1.add(answerTwelve);
        keyboardButtonsRow1.add(answerThirteen);
        keyboardButtonsRow1.add(answerFourteen);
        keyboardButtonsRow1.add(answerFifteen);
        keyboardButtonsRow1.add(answerSixteen);


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
