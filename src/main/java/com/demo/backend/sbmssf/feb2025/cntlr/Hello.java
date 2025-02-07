package com.demo.backend.sbmssf.feb2025.cntlr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String hello() {
        return "hello app started";
    }
}
