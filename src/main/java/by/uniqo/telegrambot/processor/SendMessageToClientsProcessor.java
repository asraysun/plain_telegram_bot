package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
public class SendMessageToClientsProcessor implements ProcessorI{
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public String run() {
        sendMessageForClients();
        return "Сообщение отправлено";
    }

    private void sendMessageForClients() {
        List<UserProfileData> users = userProfileRepository.findAll();
        for (UserProfileData user : users) {
            SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
            send.setChatId(user.getChatId());
//        send1.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
            send.setText("test");
//        send1.setText("номер телефона: " + userProfileData.toString());
            try {
                telegramBot.execute(send);
//            telegramBot.execute(send1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
