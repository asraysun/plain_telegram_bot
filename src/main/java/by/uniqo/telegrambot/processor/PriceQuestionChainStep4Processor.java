package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.TransferDTO;
//import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class PriceQuestionChainStep4Processor implements ProcessorI{
    @Autowired
    SendDocumentProcessor sendDocumentProcessor;
    @Autowired
    TransferDTO transferDTO;
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    LocaleMessageService localeMessageService;

    @Override
    public String run() {

        return localeMessageService.getMessage("reply.tellMeMore");
    }
}
