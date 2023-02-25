package com.example.testapi.service;

import com.example.testapi.mapper.CourseMapper;
import com.example.testapi.model.Course;
import com.example.testapi.model.CourseDto;
import com.example.testapi.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService {


    @Autowired
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDto> getAllCourse(String type, String name) {
        List<Course> list = new ArrayList<>();
        if (!type.equals("")) {
            list.addAll(courseRepository.listCourse().stream()
                    .filter(course -> course.getType().equalsIgnoreCase(type))
                    .toList());
        }
        if (!name.equals("")) {
            list.addAll(courseRepository.listCourse().stream()
                    .filter(course -> course.getType().equalsIgnoreCase(name))
                    .toList());
        }
//        if (list.size() == 0){
//
//        }
        return courseMapper.listCourseDto(list);
    }

    public CourseDto getCourse(Integer id) {
        return courseMapper.courseDto(courseRepository.getCourse(id));
    }

}
