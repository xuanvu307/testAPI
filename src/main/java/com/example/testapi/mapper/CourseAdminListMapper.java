package com.example.testapi.mapper;

import com.example.testapi.model.Course;
import com.example.testapi.model.CourseAdminList;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class CourseAdminListMapper {
    public List<CourseAdminList> courseAdminLists(List<Course> courses, Integer pageSize) {
        List<CourseAdminList> courseAdminLists = new ArrayList<>();
        int i = 0;
        while (i < courses.size()) {
            CourseAdminList courseAdminList = new CourseAdminList();
            courseAdminList.setCurrPage(1);
            courseAdminList.setTotalItem(courses.size());
            courseAdminList.setPageSize(pageSize);
            courseAdminList.setTotalPage(courses.size() / pageSize + 1);
            List<Course> currList = new ArrayList<>();
            int j = 1;
            while (j <= pageSize && i < courses.size()) {
                currList.add(courses.get(i));
                i++;
                j++;
            }
            courseAdminList.setData(currList);
            courseAdminList.setCurrPage(courseAdminList.getCurrPage() + 1);
        }
        return courseAdminLists;
    }
}
