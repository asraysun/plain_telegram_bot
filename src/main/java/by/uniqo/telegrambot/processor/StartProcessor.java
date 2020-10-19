package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.buttons.ReplyKeyboard.MainMenuButton;
import by.uniqo.telegrambot.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartProcessor implements ProcessorI {
//    @Autowired
//    MessageSource messageSource;
//    private final Locale locale;
//    public StartProcessor(@Value("${localeTag}") String localeTag, MessageSource messageSource) {
//        this.messageSource = messageSource;
//        this.locale = Locale.forLanguageTag(localeTag);
//    }

    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("reply.Start", null, localeMessageService.getLocale());
    }
}