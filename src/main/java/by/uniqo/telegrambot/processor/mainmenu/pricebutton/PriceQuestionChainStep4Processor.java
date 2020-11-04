package by.uniqo.telegrambot.processor.mainmenu.pricebutton;

//import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceQuestionChainStep4Processor implements ProcessorI {

    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {

        return localeMessageService.getMessage("reply.tellMeMore");
    }
}
