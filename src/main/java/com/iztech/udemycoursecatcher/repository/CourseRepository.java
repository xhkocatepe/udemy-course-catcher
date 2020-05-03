package com.iztech.udemycoursecatcher.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iztech.udemycoursecatcher.model.Course;

public interface CourseRepository extends MongoRepository<Course,String>{
	
	//public List<Course> findBySubCategory(String subCategory);

}
