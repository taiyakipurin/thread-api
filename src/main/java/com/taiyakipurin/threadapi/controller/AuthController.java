package com.taiyakipurin.threadapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class AuthController
{
    @GetMapping("/auth")
    public String auth()
    {
        return "auth";
    }
}
