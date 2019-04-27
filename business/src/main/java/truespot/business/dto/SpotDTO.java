package truespot.business.dto;

import lombok.Data;
import truespot.model.Topo;

@Data
public class SpotDTO
{
    private Long id;
    private Topo topo;
    private String name;
    private String description;
    private String nearestCity;
    private Boolean carAccess;
    private Boolean carParking;
    private String accessDescription;
    private String nearestHospital;
    private String supplyComment;
}
