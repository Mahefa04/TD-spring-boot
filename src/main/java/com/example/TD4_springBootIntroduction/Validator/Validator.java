package com.example.TD4_springBootIntroduction.Validator;

import com.example.TD4_springBootIntroduction.Entity.Student;
import com.example.TD4_springBootIntroduction.Exception.BadRequestException;

import java.util.List;

public class Validator {
    public void validate(List<Student> students) {
        for (Student s : students) {
            if(s.getReference() == null || s.getReference().isEmpty()) {
                throw new BadRequestException("Reference cannot be null or empty");
            }
            if(s.getFirstName() == null || s.getFirstName().isEmpty()) {
                throw new BadRequestException("First Name cannot be null or empty");
            }
            if(s.getLastName() == null || s.getLastName().isEmpty()) {
                throw new BadRequestException("Last Name cannot be null or empty");
            }
        }
    }
}
