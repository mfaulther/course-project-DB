package org.example.courseproject.controller.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentCreatedResponse {

    private long studentId;
    private String info;

}
