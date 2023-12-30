package com.task.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.models.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
   
}
