package truespot.webapp.dto;

import lombok.Data;

@Data
public class AreaDTO {

    private long id;
    private String name;
    private String description;
    private String orientation;
    private int roadNumber;
    private int height;

}
