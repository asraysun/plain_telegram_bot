package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class SevenProcessor implements ProcessorI {

    @Override
    public String run() {
        return "/seven";
    }
}
