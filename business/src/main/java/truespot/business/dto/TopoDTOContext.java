package truespot.business.dto;


import lombok.Data;

import java.util.Date;


@Data
public class TopoDTOContext {

    private String name;
    private String userPseudo;
    private Long idDepartment;
    private Date release_Date;
    private String description;
    private String nearestCity;
    private Boolean carAccess;
    private Boolean carParking;
    private String accessDescription;
    private String nearestHospital;
    private String supplyComment;
    private String avaible;
    private Boolean isAmical;
}