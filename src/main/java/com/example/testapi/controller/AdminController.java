package com.example.testapi.controller;

import com.example.testapi.model.CourseAdminList;
import com.example.testapi.model.CourseDto;
import com.example.testapi.request.UpsertCourseRequest;
import com.example.testapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/admin/courses")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("")
    public CourseAdminList getListCourse(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        return adminService.getListCourse(page,pageSize);
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
