package by.uniqo.telegrambot.webservivce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/index")
    public String greeting() {
        return "index";
    }
    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

}