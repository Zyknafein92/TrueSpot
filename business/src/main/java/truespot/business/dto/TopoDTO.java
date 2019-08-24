package truespot.business.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TopoDTO {

    private Long id;
    private String name;
    private UserDTO user;
    private DepartmentDTO department;
    private Date releaseDate;
    private String description;
    private String nearestCity;
    private Boolean carAccess;
    private Boolean carParking;
    private String accessDescription;
    private String nearestHospital;
    private String supplyComment;
    private String avaible;

}