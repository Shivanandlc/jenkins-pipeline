package com.demo.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class controller {
    @GetMapping("/")
    public String sayHello() {
        return "A demo of Jenkins Pipeline!";
    }
}
