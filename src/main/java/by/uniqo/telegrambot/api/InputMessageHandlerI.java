package by.uniqo.telegrambot.api;

import by.uniqo.telegrambot.api.handlers.BotState;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**Обработчик сообщений
 */
public interface InputMessageHandlerI {
    SendMessage handle(Message message);

    BotState getHandlerName();
}
