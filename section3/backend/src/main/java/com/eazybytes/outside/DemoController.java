package com.eazybytes.outside;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/home")
    public String sayHello() {
        return "Hello Outside World!";
    }
}
