package com.raghu.sample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;

@RestController
public class DemoController {

    @GetMapping("/Hello")
    public String greatUser() {
        return "Hello-User time is"+ LocalDate.now(ZoneId.systemDefault());
    }
}
