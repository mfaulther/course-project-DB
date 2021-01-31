package org.example.courseproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String birthDate;
    private long groupId;


}
