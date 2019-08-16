package truespot.business.dto;


import lombok.Data;


@Data
public class TopoDTOContext {

    private String name;
    private String userPseudo;
    private Long idDepartment;
    private String description;
    private String nearestCity;
    private Boolean carAccess;
    private Boolean carParking;
    private String accessDescription;
    private String nearestHospital;
    private String supplyComment;

}