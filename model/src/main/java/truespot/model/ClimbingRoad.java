package truespot.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@ApiModel(value = "ClimbingRoad")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Entity
@Getter
@Setter
@Table(name="climbing_road", schema="public")
public class ClimbingRoad implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="area_id")
    private Area area;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="number")
    private int number;

    @Column(name="letter")
    private char letter;

    @Column(name="symbol")
    private char symbol;

    public ClimbingRoad() {

    }

    public ClimbingRoad(String name, String description, String type, int number, char letter, char symbol) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.number = number;
        this.letter = letter;
        this.symbol = symbol;
    }

    public ClimbingRoad(Area area, String name, String description, String type, int number, char letter, char symbol) {
        this.area = area;
        this.name = name;
        this.description = description;
        this.type = type;
        this.number = number;
        this.letter = letter;
        this.symbol = symbol;
    }


}
