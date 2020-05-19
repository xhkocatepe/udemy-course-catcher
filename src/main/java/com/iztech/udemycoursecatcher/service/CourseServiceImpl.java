package com.iztech.udemycoursecatcher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.integration.udemy.connector.UdemyCourseConnector;
import com.iztech.udemycoursecatcher.repository.CourseRepository;
import com.iztech.udemycoursecatcher.util.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final UdemyCourseConnector udemyCourseConnector;

    public List<Course> saveCourse() {
        List<Course> courses = null;
        try{
            courses = CourseMapper.convertToModel(udemyCourseConnector.get());
            courseRepository.saveAll(courses);
        }catch (Exception e){
            e.printStackTrace();
        }

        return courses;
    }
}
