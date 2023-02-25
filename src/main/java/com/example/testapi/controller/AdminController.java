package com.example.testapi.controller;

import com.example.testapi.model.CourseDto;
import com.example.testapi.request.UpsertCourseRequest;
import com.example.testapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin/courses")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("")
    public List<CourseDto> getListCourse(){
        return adminService.getListCourse();
    }

    @PostMapping("")
    public CourseDto creatCourse(@Valid @RequestBody UpsertCourseRequest request){
        return adminService.creatCourse(request);
    }

    @GetMapping("{id}")
    public CourseDto getCourse(@PathVariable Integer id){
        return adminService.getCourse(id);
    }
    @PutMapping("{id}")
    public CourseDto editCourse(@PathVariable Integer id,@Valid @RequestBody UpsertCourseRequest request){
        return adminService.editCourse(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Integer id){
        adminService.deleteCourse(id);
    }
}