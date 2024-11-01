package com.ofir.spring_data_jpa_tutorial.respository;

import com.ofir.spring_data_jpa_tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
