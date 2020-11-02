package by.uniqo.telegrambot.buttons.ReplyKeyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainMenuButtonForAdditionMenu extends ReplyKeyboardMarkup {


    public ReplyKeyboardMarkup getAdditionMenuKeyboard() {

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row4 = new KeyboardRow();
        KeyboardButton sendContact = new KeyboardButton();
        sendContact.setText("Поделиться контактом");
        sendContact.setRequestContact(true);
        row4.add(sendContact);
        row4.add(new KeyboardButton("Нет"));
        keyboard.add(row4);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
