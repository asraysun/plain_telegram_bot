package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.TransferDTO;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.service.LocaleMessageService;
import by.uniqo.telegrambot.service.RequestDispatcher;

import by.uniqo.telegrambot.utils.Emojis;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendDocumentProcessor implements ProcessorI{

    @Autowired
    TransferDTO transferDTO;

    @Override
    public String run() {
        return transferDTO.toString();
    }
}
