package by.uniqo.telegrambot.enums;

public enum BotCommand {
    START("/start"),
    HELP("/help"),
    SETTING("/settings"),
    NONE("/none"),
    SEVEN("/seven"),
    ABOUTBOT("Что умеет чат бот"),
    SCOPEOFAPP("Сферы применения"),
    PRICE("Узнать стоймость"),
    FAQ("Ответы на частые вопросы"),
    TELLMEMORE("Узнать больше"),
    MANAGER("Связаться с менеджером"),
    ABOUTOURBOT("Что умеют наши боты?"),
    PRICEQUESTIONCHAIN,
    PRICEQUESTIONCHAINSTEP1,
    PRICEQUESTIONCHAINSTEP2,
    PRICEQUESTIONCHAINSTEP3,
    PRICEQUESTIONCHAINSTEP4,
    SENDDOCUMENT,
    SENDPHONEERROR;



    String command;
    public String getCommand() {
        return command;
    }

    BotCommand() {

    }

    BotCommand(String command) {
        this.command = command;
    }

}
