package by.uniqo.telegrambot.processor.mainmenu.pricebutton;

import by.uniqo.telegrambot.bean.TelegramBot;
import by.uniqo.telegrambot.model.UserProfileData;
import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class PriceQuestionChainStep3Processor implements ProcessorI {
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    UserProfileRepository userProfileRepository;
    public static long chatId;

    @Override
    public String run() {
        if(userProfileRepository.findUserProfileDataByChatId(chatId) != null) {
            UserProfileData userProfileData = userProfileRepository.findUserProfileDataByChatId(chatId);
        SendMessage send = new SendMessage();
//        SendMessage send1 = new SendMessage();
        send.setChatId(1307084432L);
//        send1.setChatId((long) 764602851);
//        764602851 - id в телеге Антона
//        1307084432 - id Nastya
        send.setText("номер телефона: " + userProfileData.toString());
//        send1.setText("номер телефона: " + userProfileData.toString());
        try {
            telegramBot.execute(send);
//            telegramBot.execute(send1);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }}
        return "Поделиться контактом";
    }
}
