package com.msastory.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.msastory.search.service.SearchService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/firstTest")
    public String testApString() {
        return "test";
    }
    
    @GetMapping("/informations/{nickname}")
    public String getCharacterInfoBy(@PathVariable("nickname") String nickname) {
        return searchService.getCharactorInfoBy(nickname);
    }
}
