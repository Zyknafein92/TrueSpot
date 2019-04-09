package truespot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="spot", schema="public")
public class Spot implements Serializable {

    private static final long serialVersionUID = -3746412473835952080L;


    @Id
    @Column(name = "topo_id")
    private Topo topo;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="nearest_city")
    private String nearestCity;
    @Column(name="car_access")
    private Boolean carAccess;
    @Column(name="car_parking")
    private Boolean carParking;
    @Column(name="access_description")
    private String accessDescription;
    @Column(name="nearest_hospital")
    private String nearestHospital;
    @Column(name="supply_comment")
    private String supplyComment;

    public Spot() {
    }

    public Spot(String name, String description, String nearestCity, Boolean carAccess, Boolean carParking, String accessDescription, String nearestHospital, String supplyComment) {
        this.name = name;
        this.description = description;
        this.nearestCity = nearestCity;
        this.carAccess = carAccess;
        this.carParking = carParking;
        this.accessDescription = accessDescription;
        this.nearestHospital = nearestHospital;
        this.supplyComment = supplyComment;
    }
}