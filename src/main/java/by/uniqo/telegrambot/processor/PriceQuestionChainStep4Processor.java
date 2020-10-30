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
        SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
        send.setChatId((long) 1307084432);
//        send1.setChatId((long) 956524755);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
        send.setText("номер телефона: " + transferDTO.toString());
//        send1.setText("номер телефона: " + transferDTO.toString());
        try {

            telegramBot.execute(send);
//            telegramBot.execute(send1);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return localeMessageService.getMessage("reply.tellMeMore");
    }
}
