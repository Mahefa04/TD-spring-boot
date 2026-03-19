/*
package com.example.TD3_spingBootIntroduction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world !";    }
}
*/
package com.example.TD2_spingBootIntroduction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return "welcome " + name;
    }
}