package com.sun.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsRestController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello Prasun Patidar..!";
    }
}
