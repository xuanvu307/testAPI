package com.example.testapi.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseAdminList {
    private Integer currPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalItem;
    private List<CourseDto> data;
}
