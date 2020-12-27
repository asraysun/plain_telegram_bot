package by.uniqo.telegrambot.processor.mainmenu.briefQuestionChain;

import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BriefQuestionFourProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {
        return localeMessageService.getMessage("button.answerFour" , null, localeMessageService.getLocale());
    }
}
