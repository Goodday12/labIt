package lab.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String startPage(){
    return "index";
    }

    @GetMapping("/index")
    public String index(){
    return "redirect:/";
    }

}
