package com.Vaccini.Vaccini.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/kitemm")
        public String ciaone(){
        return "kitemm";
    }
}
