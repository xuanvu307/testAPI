package com.example.testapi.mapper;

import com.example.testapi.exception.NotFoundException;
import com.example.testapi.model.Course;
import com.example.testapi.model.CourseAdminList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseAdminListMapper {

    @Autowired
    private CourseMapper courseMapper;

    public CourseAdminList courseAdminList(List<Course> courses, Integer page, Integer pageSize) {
        List<CourseAdminList> courseAdminLists = new ArrayList<>();
        if (page == null){
            page = 1;
        }
        int i = 0;
        int currPage = 1;
        while (i < courses.size()) {
            CourseAdminList courseAdminList = new CourseAdminList();
            courseAdminList.setCurrPage(currPage);
            courseAdminList.setTotalItem(courses.size());
            courseAdminList.setPageSize(pageSize);
            courseAdminList.setTotalPage((int) Math.ceil((double) courses.size() / pageSize));
            List<Course> data = new ArrayList<>();
            int j = 1;
            while (j <= pageSize && i < courses.size()) {
                data.add(courses.get(i));
                i++;
                j++;
            }
            currPage++;
            courseAdminList.setData(courseMapper.listCourseDto(data));
            courseAdminLists.add(courseAdminList);
        }
        if (page > courseAdminLists.size() || page <= 0) {
            throw new NotFoundException("số trang phải nhỏ hơn " + courseAdminLists.size());
        }
        return courseAdminLists.get(page - 1);
    }

}
