package com.dailycodedbuffer.Springboottutorial.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this tell HelloController is a Rest COntroller. which always return a response body.
public class HelloController {

    @GetMapping("/") // we put GetMapping annotation to tell this method is a get method and can access via "/" url.
    public String helloWorld(){
        return "Welcome to dialy code 888";
    }
}
