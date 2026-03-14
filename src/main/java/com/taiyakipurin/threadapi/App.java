package com.taiyakipurin.threadapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class App
{
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
        System.out.println("Hello!");
    }
}