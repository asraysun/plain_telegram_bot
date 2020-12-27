package by.uniqo.telegrambot.buttons.InlineKeyboard.buttonsForBrief;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonsForFiveQuestion extends InlineKeyboardMarkup {


    public InlineKeyboardMarkup getButtonsForFiveQuestionMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton answerTwentyThree = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton answerTwentyFour = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton answerTwentyFive = new InlineKeyboardButton().setText("3");
        InlineKeyboardButton answerTwentySix = new InlineKeyboardButton().setText("4");
        InlineKeyboardButton answerTwentySeven = new InlineKeyboardButton().setText("5");


        //Every button must have callBackData, or else not work !
        answerTwentyThree.setCallbackData("answerTwentyThree");
        answerTwentyFour.setCallbackData("answerTwentyFour");
        answerTwentyFive.setCallbackData("answerTwentyFive");
        answerTwentySix.setCallbackData("answerTwentySix");
        answerTwentySeven.setCallbackData("answerTwentySeven");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(answerTwentyThree);
        keyboardButtonsRow1.add(answerTwentyFour);
        keyboardButtonsRow1.add(answerTwentyFive);
        keyboardButtonsRow1.add(answerTwentySix);
        keyboardButtonsRow1.add(answerTwentySeven);


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
