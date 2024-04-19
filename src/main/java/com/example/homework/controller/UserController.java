package com.example.homework.controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/")
    public String greeting() {
        return "welcome";
    }


}
