package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonsForFourthQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getButtonsForFourthQuestionMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerEighteen = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton answerNineteen = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton answerTwenty = new InlineKeyboardButton().setText("3");
        InlineKeyboardButton answerTwentyOne = new InlineKeyboardButton().setText("4");
        InlineKeyboardButton answerTwentyTwo = new InlineKeyboardButton().setText("5");


        //Every button must have callBackData, or else not work !
        answerEighteen.setCallbackData("answerEighteen");
        answerNineteen.setCallbackData("answerNineteen");
        answerTwenty.setCallbackData("answerTwenty");
        answerTwentyOne.setCallbackData("answerTwentyOne");
        answerTwentyTwo.setCallbackData("answerTwentyTwo");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerEighteen);
        keyboardButtonsRow1.add(answerNineteen);
        keyboardButtonsRow1.add(answerTwenty);
        keyboardButtonsRow1.add(answerTwentyOne);
        keyboardButtonsRow1.add(answerTwentyTwo);


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
