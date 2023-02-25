package com.example.testapi.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Integer id;
    private String name;
    private  String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User user;
}
