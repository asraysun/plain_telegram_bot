package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class PriceQuestionChainStep2Processor implements ProcessorI{

    @Override
    public String run() {
        return "Укажите количество работников";
    }
}
