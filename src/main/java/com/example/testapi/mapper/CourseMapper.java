package com.example.testapi.mapper;

import com.example.testapi.model.Course;
import com.example.testapi.model.CourseDto;
import com.example.testapi.model.User;
import com.example.testapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapper {

    @Autowired
    private UserRepository userRepository;

    public CourseDto courseDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setType(course.getType());
        courseDto.setTopics(course.getTopics());
        courseDto.setThumbnail(course.getThumbnail());
        User user = userRepository.getUser(course.getUserId());
        courseDto.setUser(user);
        return courseDto;
    }

    public List<CourseDto> listCourseDto(List<Course> courses){
        return courses.stream()
                .map(course -> courseDto(course))
                .toList();
    }
}
