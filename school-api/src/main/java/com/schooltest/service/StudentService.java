package com.schooltest.service;

import com.schooltest.entity.Student;
import com.schooltest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //addstudent
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //deletestudent
    public String deleteStudent(Long id){
        studentRepository.deleteById(id);
        return "Deleted successfully!";
    }

    //readstudent
    public Optional<Student> readStudent(Long id){
       return studentRepository.findById(id);
    }

    //readAll
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //updatestudent
     public Student updateStudent(Student student){
     Student existingstudent = studentRepository.findById(student.getId()).orElseThrow();
     existingstudent.setFirstname(student.getFirstname());
     existingstudent.setLastname(student.getLastname());
     existingstudent.setMiddlename(student.getMiddlename());
     existingstudent.setDateOfJoining(student.getDateOfJoining());

     Student updatedstudent = studentRepository.save(existingstudent);

     return updatedstudent;


    }



}
