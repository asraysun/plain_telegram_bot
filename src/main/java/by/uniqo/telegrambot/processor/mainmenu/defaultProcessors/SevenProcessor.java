package by.uniqo.telegrambot.processor.mainmenu.defaultProcessors;

import by.uniqo.telegrambot.processor.ProcessorI;
import by.uniqo.telegrambot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SevenProcessor implements ProcessorI {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public String run() {
        return "/seven";
    }
}
