package com.example.TD4_springBootIntroduction.Controller;

import com.example.TD4_springBootIntroduction.Entity.Student;
import com.example.TD4_springBootIntroduction.Exception.BadRequestException;
import com.example.TD4_springBootIntroduction.Service.Service;
import com.example.TD4_springBootIntroduction.Validator.Validator;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;

@RestController
public class Controller {

    private final Service studentService = new Service();
    private final Validator studentValidator = new Validator();

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {

        if (name == null || name.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Nom manquant !");
        }

        return ResponseEntity
                .ok("Welcome " + name);
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudents(@RequestBody List<Student> studentList) {
        try {
            studentValidator.validate(studentList);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(studentService.addStudent(studentList));
        } catch (BadRequestException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                    .status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .body(e.getMessage());
        }
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
