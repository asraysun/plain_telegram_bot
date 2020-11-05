package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.utils.Emojis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
public class AdminSendClientsListProcessor implements ProcessorI {
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    TelegramBot telegramBot;

    @Override
    public String run() {
        List<UserProfileData> users = userProfileRepository.findAll();
        for (UserProfileData user : users) {
            SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
            send.setChatId(1307084432L);
//        send1.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
            send.setText("номер телефона: " + user.toString());
//        send1.setText("номер телефона: " + userProfileData.toString());
            try {
                telegramBot.execute(send);
//            telegramBot.execute(send1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return localeMessageService.getMessage("reply.clientsList", null, localeMessageService.getLocale());
    }
}
