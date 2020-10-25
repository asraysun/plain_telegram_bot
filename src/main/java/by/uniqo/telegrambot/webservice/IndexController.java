package by.uniqo.telegrambot.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String greeting() {
        return "index";
    }
    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

}