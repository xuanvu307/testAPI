package com.example.testapi.repository;

import com.example.testapi.dao.CourseDB;
import com.example.testapi.exception.BadRequest;
import com.example.testapi.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    public Course getCourse(Integer id){
        return listCourse().stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->{
                    throw new BadRequest("Id course không tồn tại");
                });
    }

    public List<Course> listCourse(){
        return CourseDB.courses;
    }
}
