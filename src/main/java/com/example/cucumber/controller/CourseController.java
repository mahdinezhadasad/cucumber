package com.example.cucumber.controller;

import com.udacity.api.CourseApi;
import com.udacity.api.CoursesApi;
import com.example.cucumber.entity.CourseEntity;
import com.udacity.model.Course;
import com.example.cucumber.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@RestController
public class CourseController implements CourseApi, CoursesApi {
    @Autowired
    CourseRepository courseRepository;
    public CourseEntity convertCourseToCourseEntity(Course course){
        return new CourseEntity(course.getId(), course.getTitle(), course.getDescription());
    }
    public Course convertCourseEntityToCourse(CourseEntity courseEntity){
        Course course = new Course();
        course.setId(courseEntity.getId());
        course.setTitle(courseEntity.getTitle());
        course.setDescription(courseEntity.getDescription());
        return course;
    }
    @Override
    public ResponseEntity<String> addCourse(Course course) {
        return ResponseEntity.ok(courseRepository.save(convertCourseToCourseEntity(course)).toString());
    }
    @Override
    public ResponseEntity<List<Course>> getCourse(Integer id) {
        return ResponseEntity.ok(Arrays.asList(convertCourseEntityToCourse(courseRepository.findById(id).get())));
    }
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }
}