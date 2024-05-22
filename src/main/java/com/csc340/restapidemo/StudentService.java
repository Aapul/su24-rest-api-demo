package com.csc340.restapidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Object getAllStudent() { return studentRepository.findAll();}

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Object getHonorsStudents(double gpa){
        return studentRepository.getHonorsStudents(gpa);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(int id, Student updatedStudent) {
        studentRepository.findById(id).ifPresent(student -> {
            student.setName(updatedStudent.getName());
            student.setMajor(updatedStudent.getMajor());
            student.setGpa(updatedStudent.getGpa());
            studentRepository.save(student);
        });
    }
}
