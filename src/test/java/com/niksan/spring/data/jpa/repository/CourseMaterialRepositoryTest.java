package com.niksan.spring.data.jpa.repository;

import com.niksan.spring.data.jpa.entity.Course;
import com.niksan.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();
        CourseMaterial courseMaterial =
                CourseMaterial
                .builder()
                        .url("www.udemy.com")
                        .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("course material = "  + courseMaterials);
    }

}