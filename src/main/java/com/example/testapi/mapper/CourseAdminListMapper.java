package com.example.testapi.mapper;

import com.example.testapi.model.Course;
import com.example.testapi.model.CourseAdminList;
import com.example.testapi.model.CourseDto;
import com.example.testapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseAdminListMapper {
    @Autowired
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;
    List<CourseDto> courseDtos = courseMapper.listCourseDto(courseRepository.listCourse());

    public List<CourseAdminList> courseAdminLists(Integer page, Integer pageSize) {
        List<CourseAdminList> courseAdminLists = new ArrayList<>();
        int i = 0;
        while (i < courseDtos.size()) {
            CourseAdminList courseAdminList = new CourseAdminList();
            courseAdminList.setCurrPage(1);
            courseAdminList.setTotalItem(courseDtos.size());
            courseAdminList.setPageSize(pageSize);
            courseAdminList.setCurrPage(page);
            courseAdminList.setTotalPage(courseDtos.size() / pageSize + 1);
            List<CourseDto> currList = new ArrayList<>();
            int j = pageSize;
            while (j > 0) {
                currList.add(courseDtos.get(i));
                i++;
                j--;
            }
            courseAdminList.setData(currList);
            courseAdminList.setCurrPage(courseAdminList.getCurrPage() + 1);
        }
        return courseAdminLists;
    }
}
