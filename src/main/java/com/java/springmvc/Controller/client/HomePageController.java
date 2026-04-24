package com.java.springmvc.Controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String gẹHomePage() {
        return "client/home/view-home";
    }
}
