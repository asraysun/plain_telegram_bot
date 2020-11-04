package by.uniqo.telegrambot.processor.mainmenu.errors;

import by.uniqo.telegrambot.processor.ProcessorI;
import org.springframework.stereotype.Service;

@Service
public class NoneProcessor implements ProcessorI {

    @Override
    public String run() {
        return "Unexpected command";
    }
}