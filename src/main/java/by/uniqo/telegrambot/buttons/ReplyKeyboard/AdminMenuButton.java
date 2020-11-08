package by.uniqo.telegrambot.buttons.ReplyKeyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminMenuButton extends ReplyKeyboardMarkup {


    public ReplyKeyboardMarkup getAdminMenuKeyboard() {

        final ReplyKeyboardMarkup replyKeyboardMarkupAdmin = new ReplyKeyboardMarkup();
        replyKeyboardMarkupAdmin.setSelective(true);
        replyKeyboardMarkupAdmin.setResizeKeyboard(true);
        replyKeyboardMarkupAdmin.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(new KeyboardButton("Список клиентов"));
        row1.add(new KeyboardButton("Поиск клиентов по "));
        row2.add(new KeyboardButton("Отправить сообщение клиенту"));
        row3.add(new KeyboardButton("Удалить сообщение у клиента"));
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        replyKeyboardMarkupAdmin.setKeyboard(keyboard);
        return replyKeyboardMarkupAdmin;
    }
}
