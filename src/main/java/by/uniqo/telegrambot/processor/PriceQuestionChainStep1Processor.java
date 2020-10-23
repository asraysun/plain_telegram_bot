package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class PriceQuestionChainStep1Processor implements ProcessorI {

    @Override

    public String run() {
        return "Выберите тип навыка бота";
    }
}
