package truespot.webapp.dto;

import lombok.Data;
import truespot.model.Department;
import truespot.model.User;

@Data
public class TopoDTO {

    private long id;
    private String name;
    private User user;
    private Department department;


}
