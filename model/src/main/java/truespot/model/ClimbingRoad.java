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

    @OneToOne
    private Difficulty difficulty;

    @Column(name="climbing_road_type")
    private ClimbingRoadType type;

    public ClimbingRoad(Area area, String name, String description, Difficulty difficulty, ClimbingRoadType type) {
        this.area = area;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.type = type;
    }


    public ClimbingRoad() {

    }

}
