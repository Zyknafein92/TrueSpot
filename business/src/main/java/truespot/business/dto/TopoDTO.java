package truespot.business.dto;


import lombok.Data;



@Data
public class TopoDTO {
    private long id;
    private String name;
    private UserDTO user;
    private DepartmentDTO department;
}
