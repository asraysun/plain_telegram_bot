package by.uniqo.telegrambot.processor.mainmenu;

import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeOfAppProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("reply.fieldOfApplication", Emojis.CART,
                Emojis.MONEYBAG, Emojis.SHIELD, Emojis.PILL, Emojis.HOMES, Emojis.BENTO,
        Emojis.DESKTOP, Emojis.RAILROAD_TRACK);
    }
}
