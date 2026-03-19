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

import com.example.TD2_spingBootIntroduction.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {

        return "welcome " + name;
    }

    List<Student> students = new ArrayList<>();
    @PostMapping("/students")
    public List<Student> addStudent(@RequestBody List<Student> studentList) {
        students.addAll(studentList);
        return students;
    }

    @GetMapping("/students")
    public Object getStudentName(@RequestHeader ("Accept") String name) {
        if(name.equals("Accept")) {
            return students;
        }
        return "Format non supporté";
    }
}