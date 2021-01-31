package org.example.courseproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GroupDTO {

    @JsonIgnore
    private long id;
    private String title;
    private String level;
    private String direction;
    private long facultyId;


}
