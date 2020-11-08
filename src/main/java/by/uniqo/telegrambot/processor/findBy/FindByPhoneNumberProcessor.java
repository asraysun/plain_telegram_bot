package by.uniqo.telegrambot.processor.findBy;

import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByPhoneNumberProcessor implements ProcessorI {

    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("reply.findByPhoneNumber", null, localeMessageService.getLocale());
    }
}