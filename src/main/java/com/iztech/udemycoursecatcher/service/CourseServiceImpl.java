package com.iztech.udemycoursecatcher.service;

import com.iztech.udemycoursecatcher.integration.udemy.client.Course;
import com.iztech.udemycoursecatcher.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> saveCourse(List<Course> courseList){
        return null;
    }
}
