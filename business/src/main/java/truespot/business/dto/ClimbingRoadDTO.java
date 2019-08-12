package truespot.business.dto;

import lombok.Data;

@Data
public class ClimbingRoadDTO {

    private Long id;
    private String idArea;
    private String name;
    private String description;
    private String type;
    private int number;
    private char letter;
    private char symbol;
}
