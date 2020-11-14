package by.uniqo.telegrambot.cache;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataCache {
    private String setStatus = "stop";
    private String flag = "idInputOk";
    private Long userId;
}
