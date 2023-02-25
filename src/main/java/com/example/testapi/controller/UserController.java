package com.example.testapi.controller;

import com.example.testapi.model.CourseDto;
import com.example.testapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/courses")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<CourseDto> getAllCourse(@RequestParam String type, @RequestParam String name, @RequestParam String topic) {
        return userService.getAllCourse(type, name, topic);
    }

    @GetMapping("{id}")
    public CourseDto getCourse(@PathVariable Integer id) {
        return userService.getCourse(id);
    }

}
