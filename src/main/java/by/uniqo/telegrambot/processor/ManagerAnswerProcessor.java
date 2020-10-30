package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerAnswerProcessor implements ProcessorI{
    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("reply.ManagerAnswer",  null, localeMessageService.getLocale());
    }
}
