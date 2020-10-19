package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class NoneProcessor implements ProcessorI {

    @Override
    public String run() {
        return "Unexpected command";
    }
}