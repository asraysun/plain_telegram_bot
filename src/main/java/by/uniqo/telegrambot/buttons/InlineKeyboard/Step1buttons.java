package by.uniqo.telegrambot.buttons.InlineKeyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
@Component
public class Step1buttons extends InlineKeyboardMarkup{



        public InlineKeyboardMarkup getButtonsMarkupStep1() {
            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            InlineKeyboardButton buttonSetPrice = new InlineKeyboardButton().setText("Расчитать");

            //Every button must have callBackData, or else not work !
            buttonSetPrice.setCallbackData("buttonSetPrice");

            List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
            keyboardButtonsRow1.add(buttonSetPrice);

            List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
            rowList.add(keyboardButtonsRow1);

            inlineKeyboardMarkup.setKeyboard(rowList);

            return inlineKeyboardMarkup;
        }
}
