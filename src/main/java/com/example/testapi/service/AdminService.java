package com.example.testapi.service;

import com.example.testapi.dao.CourseDB;
import com.example.testapi.mapper.CourseMapper;
import com.example.testapi.model.Course;
import com.example.testapi.model.CourseAdminList;
import com.example.testapi.model.CourseDto;
import com.example.testapi.repository.CourseRepository;
import com.example.testapi.repository.UserRepository;
import com.example.testapi.request.UpsertCourseRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AdminService {

    @Autowired
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    private final List<Course> courses = courseRepository.listCourse();

    private int genId() {
        return courses.get(courses.size() - 1).getId() + 1;
    }

    public CourseAdminList getListCourse(Integer page, Integer pageSize) {
        CourseAdminList courseAdminList = new CourseAdminList();
        int currpage = page;
        int size = pageSize;
        int totalItem = courses.size();
        int totalPage = totalItem/pageSize;
        return null;
    }

    //2. Tạo khóa học mới

    public CourseDto creatCourse(UpsertCourseRequest request) {
        Course course = Course.builder()
                .id(genId())
                .name(request.getName())
                .description(request.getDescription())
                .type(request.getType())
                .topics(request.getTopics())
                .thumbnail(request.getThumbnail())
                .userId(request.getUserId())
                .build();
        CourseDB.courses.add(course);
        return courseMapper.courseDto(course);
    }


    //3. Lấy chi tiết khóa học
    public CourseDto getCourse(Integer id) {
        return courseMapper.courseDto(courseRepository.getCourse(id));
    }

    //4. Cập nhật thông tin khóa học
    public CourseDto editCourse(Integer id, UpsertCourseRequest request) {
        Course course = courseRepository.getCourse(id);

        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setType(request.getType());
        course.setTopics(request.getTopics());
        course.setThumbnail(request.getThumbnail());
        course.setUserId(request.getUserId());

        return courseMapper.courseDto(course);
    }

    //5. Xóa khóa học
    public void deleteCourse(Integer id) {
        CourseDB.courses.removeIf(course -> Objects.equals(course.getId(), id));

    }

}
