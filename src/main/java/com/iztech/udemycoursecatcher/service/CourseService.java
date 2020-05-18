package com.iztech.udemycoursecatcher.service;

import com.iztech.udemycoursecatcher.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
}
