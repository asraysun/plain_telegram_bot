package by.uniqo.telegrambot.processor.mainmenu.defaultProcessors;

import by.uniqo.telegrambot.processor.ProcessorI;
import org.springframework.stereotype.Service;

@Service
public class SendProcessor implements ProcessorI {

    @Override
    public String run() {
        return "Введите сообщение";
    }
}