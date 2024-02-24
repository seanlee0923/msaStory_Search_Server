package com.msastory.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

    @GetMapping("/firstTest")
    @ResponseBody
    public String testApString() {
        return "test";
    }
    
}
