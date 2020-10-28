package by.uniqo.telegrambot.processor;

import by.uniqo.telegrambot.model.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendDocumentProcessor implements ProcessorI{

    @Autowired
    TransferDTO transferDTO;

    @Override
    public String run() {
        return transferDTO.toString();
    }
}
