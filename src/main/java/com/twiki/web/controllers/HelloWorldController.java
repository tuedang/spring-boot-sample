package com.twiki.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {

    @RequestMapping
    public String sayHello() {
        return "Hello World";
    }
}
