package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSendMessageProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("reply.AboutOurBot", Emojis.BAR_CHART,
                Emojis.CALLING, Emojis.ENVELOPE_WITH_ARROW, Emojis.DOLLAR, Emojis.CREDIT_CARD,
                Emojis.MAG_RIGHT, Emojis.SHOPPING_BAGS, Emojis.GEAR, Emojis.BOOKS);
    }
}
