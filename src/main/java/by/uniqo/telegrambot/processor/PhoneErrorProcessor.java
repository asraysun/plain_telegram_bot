package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class PhoneErrorProcessor implements ProcessorI {

    @Override
    public String run() {
        return "Неверно введен номер телефона. (минимум цифр - 7)";
    }
}