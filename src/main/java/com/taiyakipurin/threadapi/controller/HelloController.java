package com.taiyakipurin.threadapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class HelloController
{
    @GetMapping("/")
    public String hello()
    {
        return "Hello";
    }
}
