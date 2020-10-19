package by.uniqo.telegrambot.buttons.ReplyKeyboard;

import by.uniqo.telegrambot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyButtonProcessor {
    @Autowired
    MessageService messageService;
    @Autowired
    MainMenuButton mainMenuButton;

//    public SendMessage createMessageWithKeyboard(MessageService messageService,
//                                                  final MainMenuButton mainMenuButton) {
//        messageService.sendMessage();
//        if (mainMenuButton != null) {
//            sendMessage.setReplyMarkup(mainMenuButton);
//        }
//        return sendMessage;
//    }
}
