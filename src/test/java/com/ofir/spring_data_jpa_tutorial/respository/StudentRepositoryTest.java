package com.ofir.spring_data_jpa_tutorial.respository;

import com.ofir.spring_data_jpa_tutorial.entity.Guardian;
import com.ofir.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("shabir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dowdy")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("student list: " + studentList);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("niki@gmail.com")
                .name("Niki")
                .mobile("999344234")
                .build();

        Student student = Student.builder()
                .firstName("Shivan")
                .emailId("shivan@gmail.com")
                .lastName("Kumai")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Shivan");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("iva");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Niki");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("Shabbir", "Dowdy");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("shabir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("shabir@gmail.com");
        assertEquals("Shabbir", studentName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("shabir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNamedParam("shabir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("sapir", "shabir@gmail.com");
    }
}