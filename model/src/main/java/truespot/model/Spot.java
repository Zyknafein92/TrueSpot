package truespot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "Spot")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
@Entity
@Table(name="spot", schema="public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Spot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private Long id;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "topo_id", referencedColumnName = "topo_id", nullable = false)
    private Topo topo;

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