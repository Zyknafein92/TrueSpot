package truespot.business.dto;

import lombok.Data;

@Data
public class AreaDTO {

    private Long id;
    private String idTopo;
    private String name;
    private String description;
    private String orientation;
    private int height;

}
