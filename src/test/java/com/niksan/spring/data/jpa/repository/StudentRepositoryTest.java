package com.niksan.spring.data.jpa.repository;

import com.niksan.spring.data.jpa.entity.Guardian;
import com.niksan.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("niksan@gmail.com")
                .firstName("Niksan")
                .lastName("Karkee")
//                .guardianName("Rijan")
//                .guardianEmail("rijan@gmail.com")
//                .guardianMobile("564564641")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("priyata@gmail.com")
                .name("Pratima")
                .mobile("654645645")
                .build();
        Student student = Student.builder()
                .firstName("Pratima")
                .lastName("karkee")
                .emailId("pratima@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList  = studentRepository.findAll();
        System.out.println("Students: " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Pratima");
        System.out.println("Students = " + students);
    }


    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ma");
        System.out.println("Students = " + students);
    }


    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Pratima");
        System.out.println("Students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student =  studentRepository.getStudentByEmailAddress("rijnik@gmail.com");
        System.out.println("Student with email = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("rijnik@gmail.com");
        System.out.println("First name = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("rijnik@gmail.com");
        System.out.println("Student from native = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNative("rijnik@gmail.com");
        System.out.println("Student from native named param = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Rajkumar Karki", "rijnik@gmail.com");
    }

}