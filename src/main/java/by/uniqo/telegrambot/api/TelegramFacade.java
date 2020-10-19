package by.uniqo.telegrambot.api;

import by.uniqo.telegrambot.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class TelegramFacade {

    @Autowired
    MessageService messageService;

}
