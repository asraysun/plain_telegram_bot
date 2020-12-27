package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonsForThirdQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getButtonsForThirdQuestionMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerSeventeen = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton answerForty = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton answerFortyOne = new InlineKeyboardButton().setText("3");
        InlineKeyboardButton answerFortyTwo = new InlineKeyboardButton().setText("4");
        InlineKeyboardButton answerFortyThree = new InlineKeyboardButton().setText("5");


        //Every button must have callBackData, or else not work !
        answerSeventeen.setCallbackData("answerSeventeen");
        answerForty.setCallbackData("answerForty");
        answerFortyOne.setCallbackData("answerFortyOne");
        answerFortyTwo.setCallbackData("answerFortyTwo");
        answerFortyThree.setCallbackData("answerFortyThree");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerSeventeen);
        keyboardButtonsRow1.add(answerForty);
        keyboardButtonsRow1.add(answerFortyOne);
        keyboardButtonsRow1.add(answerFortyTwo);
        keyboardButtonsRow1.add(answerFortyThree);


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
