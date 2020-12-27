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
        InlineKeyboardButton buttonAnswerOne = new InlineKeyboardButton().setText("1");
        InlineKeyboardButton buttonAnswerTwo = new InlineKeyboardButton().setText("2");
        InlineKeyboardButton buttonAnswerThree = new InlineKeyboardButton().setText("3");
        InlineKeyboardButton buttonAnswerFour = new InlineKeyboardButton().setText("4");
        InlineKeyboardButton buttonAnswerFive = new InlineKeyboardButton().setText("5");
        InlineKeyboardButton buttonAnswerSix = new InlineKeyboardButton().setText("6");
        InlineKeyboardButton buttonAnswerSeven = new InlineKeyboardButton().setText("7");
        InlineKeyboardButton buttonAnswerEight = new InlineKeyboardButton().setText("8");
        InlineKeyboardButton buttonAnswerNine = new InlineKeyboardButton().setText("9");


        //Every button must have callBackData, or else not work !
        buttonAnswerOne.setCallbackData("buttonAnswerOne");
        buttonAnswerTwo.setCallbackData("buttonAnswerTwo");
        buttonAnswerThree.setCallbackData("buttonAnswerThree");
        buttonAnswerFour.setCallbackData("buttonAnswerFour");
        buttonAnswerFive.setCallbackData("buttonAnswerFive");
        buttonAnswerSix.setCallbackData("buttonAnswerSix");
        buttonAnswerSeven.setCallbackData("buttonAnswerSeven");
        buttonAnswerEight.setCallbackData("buttonAnswerEight");
        buttonAnswerNine.setCallbackData("buttonAnswerNine");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(buttonAnswerOne);
        keyboardButtonsRow1.add(buttonAnswerTwo);
        keyboardButtonsRow1.add(buttonAnswerThree);
        keyboardButtonsRow1.add(buttonAnswerFour);
        keyboardButtonsRow1.add(buttonAnswerFive);
        keyboardButtonsRow1.add(buttonAnswerSix);
        keyboardButtonsRow1.add(buttonAnswerSeven);
        keyboardButtonsRow1.add(buttonAnswerEight);
        keyboardButtonsRow1.add(buttonAnswerNine);


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
