package com.iztech.udemycoursecatcher;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iztech.udemycoursecatcher.model.Course;
import com.iztech.udemycoursecatcher.service.CourseService;
import groovy.transform.Memoized;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class LambdaHandler implements RequestHandler<ScheduledEvent, String> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Memoized
    ApplicationContext getApplicationContext() {
        return UdemyCourseCatcherApplication.getAppContextForLambda();
    }

    @Override
    public String handleRequest(ScheduledEvent event, Context context)
    {

        CourseService  courseService = this.getApplicationContext().getBean(CourseService.class);
        List<Course> courses = courseService.saveCourse();

        //  log execution details
        context.getLogger().log("Added New Courses: " + gson.toJson(courses));
        context.getLogger().log("Environment Details: " + gson.toJson(System.getenv()));
        context.getLogger().log("Context: " + gson.toJson(context));
        //  log event details
        context.getLogger().log("Event: " + gson.toJson(event));
        context.getLogger().log("Event Type: " + event.getClass().toString());

        return "Successful Event!";
    }
}

