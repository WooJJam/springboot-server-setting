package woojjam.serversetting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public void pinrtHello() {
        System.out.println("Hello");
    }
}
