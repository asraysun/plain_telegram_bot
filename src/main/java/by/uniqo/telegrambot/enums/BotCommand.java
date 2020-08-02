package by.uniqo.telegrambot;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public enum BotCommand {
    START("/start"),
    HELP("/help"),
    SETTING("/settings"),
    NONE("/none");

    String command;
    public String getCommand() {
        return command;
    }

    BotCommand(String command) {
        this.command = command;
    }

}
