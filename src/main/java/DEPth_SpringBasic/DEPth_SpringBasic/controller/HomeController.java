package DEPth_SpringBasic.DEPth_SpringBasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    } //localhost:8080
    //우선 순위는 container에서 먼저 찾고, 없으면 static에서 찾게 되므로 우선순위는 controller가 더 높다.
}
