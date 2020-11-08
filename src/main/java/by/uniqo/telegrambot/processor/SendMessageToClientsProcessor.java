package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMessageToClientsProcessor implements ProcessorI{
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public String run() {
        return "Сообщение отправлено";
    }
}
