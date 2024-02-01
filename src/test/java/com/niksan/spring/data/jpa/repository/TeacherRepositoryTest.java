package com.niksan.spring.data.jpa.repository;

import com.niksan.spring.data.jpa.entity.Course;
import com.niksan.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public  void saveTeacher(){
        Course courseAws =
                Course.builder()
                        .title("AWS")
                        .credit(10)
                        .build();

        Course courseJava =
                Course.builder()
                        .title("Java")
                        .credit(10)
                        .build();

        Teacher teacher  =
                Teacher.builder()
                        .firstName("Jake")
                        .lastName("Smith")
                .build();

        teacherRepository.save(teacher);
    }

}