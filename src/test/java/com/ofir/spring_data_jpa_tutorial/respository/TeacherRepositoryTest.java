package com.ofir.spring_data_jpa_tutorial.respository;

import com.ofir.spring_data_jpa_tutorial.entity.Course;
import com.ofir.spring_data_jpa_tutorial.entity.Teacher;
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
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan")
                .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }

}