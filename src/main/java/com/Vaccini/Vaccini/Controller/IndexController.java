package com.Vaccini.Vaccini.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
        public String ciaone(){
        return "graph";
    }
}