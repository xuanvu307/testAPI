package com.example.testapi.service;

import com.example.testapi.mapper.CourseMapper;
import com.example.testapi.model.CourseDto;
import com.example.testapi.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {


    @Autowired
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDto> getAllCourse(String type, String name, String topic) {
        if (type.trim().equals("") && name.trim().equals("") && topic.trim().equals("")) {
            return courseMapper.listCourseDto(courseRepository.listCourse());
        }

        return courseMapper.listCourseDto(courseRepository.listCourse().stream()
                .filter(course -> course.getType().equalsIgnoreCase(type)
                        && course.getName().equalsIgnoreCase(name)
                        && course.getTopics().contains(topic))
                .toList());
    }

    public CourseDto getCourse(Integer id) {
        return courseMapper.courseDto(courseRepository.getCourse(id));
    }

}
