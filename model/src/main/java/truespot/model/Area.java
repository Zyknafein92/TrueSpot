package truespot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name= "area", schema="public")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long area_id;

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

    protected Area() {}

    public Area(String name, String description, String orientation, int roadNumber, int height) {
        this.name = name;
        this.description = description;
        this.orientation = orientation;
        this.roadNumber = roadNumber;
        this.height = height;
    }
}