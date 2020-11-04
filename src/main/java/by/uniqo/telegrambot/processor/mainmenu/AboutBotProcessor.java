package by.uniqo.telegrambot.processor.mainmenu;

import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutBotProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("reply.whatCanDoOurBot",
                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK, Emojis.CHECK, Emojis.CHECK,
                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK, Emojis.CHECK, Emojis.CHECK,
                Emojis.CHECK, Emojis.CHECK, Emojis.CHECK, Emojis.CHECK, Emojis.CHECK
               );
    }
}
