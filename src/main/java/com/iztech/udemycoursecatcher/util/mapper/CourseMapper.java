package com.iztech.udemycoursecatcher.util.mapper;

import com.iztech.udemycoursecatcher.integration.udemy.client.Category;
import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.model.Discount;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CourseMapper {
    public static List<Course> convertToModel(List<com.iztech.udemycoursecatcher.integration.udemy.client.Course> courseList){
        return courseList.stream().map(item -> {
            Course course = Course.builder() // course model
            .udemyId(item.getId())
            .title(item.getTitle())
            .discount(item.getDiscount())
            .url(item.getUrl())
            .isPaid(item.isPaid())
            .category(item.getCategory())
            .subCategory(item.getSubCategory())
            .publishDate(item.getPublishDate()).build();

            return course;
        }).collect(Collectors.toList());
    }
}
