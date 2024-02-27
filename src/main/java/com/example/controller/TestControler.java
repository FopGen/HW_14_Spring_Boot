package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestControler {
    @GetMapping("/test")
    public ModelAndView getTest(){
        ModelAndView result = new ModelAndView("test");
        return result;
    }

}
