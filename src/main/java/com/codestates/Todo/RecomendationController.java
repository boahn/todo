package com.codestates.Todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendationController {
    @GetMapping("/")
    public String helloworld() {
        return "To-do Application !";
    }
}
