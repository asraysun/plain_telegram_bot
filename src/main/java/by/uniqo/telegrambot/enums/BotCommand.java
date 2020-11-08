package by.uniqo.telegrambot.enums;

public enum BotCommand {
    START("/start"),
    HELP("/help"),
    SETTING("/settings"),
    SEND("/send"),
    NONE("/none"),
    SEVEN("/seven"),
    ABOUTBOT("Что умеет чат бот"),
    SCOPEOFAPP("Сферы применения"),
    PRICE("Узнать стоимость"),
    FAQ("Ответы на частые вопросы"),
    TELLMEMORE("Узнать больше"),
    MANAGER("Связаться с менеджером"),
    ABOUTOURBOT("Что умеют наши боты?"),
    FINDBY("Поиск клиентов по "),
    FINDBYNAME("Поиск клиентов по имени"),
    FINDBYID("Поиск клиентов по id(из базы данных)"),
    FINDBYPHONENUMBER("Поиск клиентов по номеру телефона"),
    FINDBYTIMESTAMP("Поиск клиентов по дате сообщения"),
    FINDBYSOMETHING,
    FINDBYINPUTMSG,
    SENDMESSAGETOCLIENTS,
    PRICEQUESTIONCHAIN,
    PRICEQUESTIONCHAINSTEP1,
    PRICEQUESTIONCHAINSTEP2,
    PRICEQUESTIONCHAINSTEP3,
    PRICEQUESTIONCHAINSTEP4,
    MANAGERANSWER,
    DELETEMESSAGE,
    SENDDOCUMENT,
    SAYTHANKS,
    SENDCLIENTSLIST,
    NEWUPDATES,
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
