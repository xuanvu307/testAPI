package com.example.testapi.dao;

import com.example.testapi.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> courses = new ArrayList<>(List.of(
            new Course(1,"Java", "Mô tả khóa học","Onlab", List.of("backend", "database" ,"devops"), "thumbnail", 1),
            new Course(2,"Python", "Mô tả khóa học","Onlab", List.of("backend", "database" ,"devops"), "thumbnail", 3),
            new Course(3,"DEVOPS", "Mô tả khóa học","Onlab", List.of("devops"), "thumbnail", 2),
            new Course(4,"DATABASE", "Mô tả khóa học","Onlab", List.of("backend", "database" ,"devops"), "thumbnail", 5),
            new Course(5,"CSS", "Mô tả khóa học","Onlab", List.of("backend", "database" ,"devops"), "thumbnail", 1),
            new Course(6,"JavaScript", "Mô tả khóa học","Online", List.of("frontend", "database" ,"devops"), "thumbnail", 4)
            ));

}
