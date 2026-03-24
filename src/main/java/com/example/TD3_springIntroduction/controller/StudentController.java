package com.example.TD3_springIntroduction.controller;

import com.example.TD3_springIntroduction.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("nom manquant !");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Welcome " + name);
    }

    List<Student> students = new ArrayList<>();
    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> studentList) {
        try {
            students.addAll(studentList);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(students);
        } catch (Exception exeption) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", required = false) String accept) {
        try {
            if (accept == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Header Accept manquant");
            }

            if (!accept.equals("text/plain") && !accept.equals("application/json")) {
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Format non supporté");
            }

            if (accept.equals("application/json")) {
                return ResponseEntity
                        .ok()
                        .body(students);
            }

            StringBuilder result = new StringBuilder();
            for (Student s : students) {
                result.append(s.getFirstName())
                        .append(" ")
                        .append(s.getLastName())
                        .append("\n");
            }

            return ResponseEntity
                    .ok()
                    .header("Content-Type", "text/plain")
                    .body(result.toString());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur serveur");
        }
    }
}
