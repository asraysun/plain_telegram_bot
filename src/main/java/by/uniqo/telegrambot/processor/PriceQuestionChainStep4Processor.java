package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class PriceQuestionChainStep4Processor implements ProcessorI{
    @Autowired
    SendDocumentProcessor sendDocumentProcessor;
    @Autowired
    UserProfileData userProfileData;
    @Autowired
    TelegramBot telegramBot;

    @Override
    public String run() {
        SendMessage send = new SendMessage();
        send.setChatId((long) 1307084432);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
        send.setText("номер телефона: " + userProfileData.toString());
        try {
            telegramBot.execute(send);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return "Спасибо за заявку. Наш менеджер свяжется с Вами в ближайшее время.";
    }
}
