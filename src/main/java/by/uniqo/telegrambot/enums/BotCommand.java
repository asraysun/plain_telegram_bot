package by.uniqo.telegrambot.enums;

public enum BotCommand {
    START("/start"),
    HELP("/help"),
    SETTING("/settings"),
    NONE("/none"),
    SEVEN("/seven"),
    ABOUTBOT("Что умеет чат бот"),
    SCOPEOFAPP("Сферы применения"),
    PRICE("Стоимость"),
    FAQ("Ответы на частые вопросы"),
    TELLMEMORE("Узнать больше"),
    MANAGER("Связаться с менеджером");


    String command;
    public String getCommand() {
        return command;
    }

    BotCommand(String command) {
        this.command = command;
    }

}
