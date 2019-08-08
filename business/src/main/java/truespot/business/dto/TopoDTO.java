package truespot.business.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TopoDTO {

    private Long id;
    private String name;
    private UserDTO user;
    private DepartmentDTO department;


//    @JsonProperty("department")
//    private void unpackNested(Long department) {
//        this.department = new DepartmentDTO();
//        this.department.setId(department);
//    }
}