package com.example.testapi.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpsertCourseRequest {
    @NotBlank(message = "ô name trống")
    private String name;
    @Size(min = 50, message = "có độ dài ký tự > 50")
    private String description;
    @NotBlank(message = "ô type trống")
    private String type;
    private List<String> topics;
    private String thumbnail;
    @NotNull(message = "ô userId trống")
    private Integer userId;
}
