package com.example.cucumber.service;

import com.example.cucumber.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class CourseService {
    @Autowired
    CourseRepository repository;
}
