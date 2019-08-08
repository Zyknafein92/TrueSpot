package truespot.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@ApiModel(value = "Area")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
@Entity
@Table(name= "area", schema="public")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="area_id")
    private Long id;

   // private Spot spot;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="orientation")
    private String orientation;
    @Column(name="road_number")
    private int roadNumber;
    @Column(name="height")
    private int height;

    public Area() {}

    public Area(String name, String description, String orientation, int roadNumber, int height) {
        this.name = name;
        this.description = description;
        this.orientation = orientation;
        this.roadNumber = roadNumber;
        this.height = height;
    }

}