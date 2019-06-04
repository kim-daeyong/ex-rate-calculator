package example.daeyong.kim.exratecalculator.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {


    @GetMapping("/")
    private String main() {
        return "index";
    }
}
