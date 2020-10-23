package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class PriceQuestionChainStep3Processor implements ProcessorI{

    @Override
    public String run() {
        return "Укажите номер телефона для связи";
    }
}
