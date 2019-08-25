package truespot.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "Topo")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
@Entity
@Table(name="topo", schema="public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topo_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User user;

    @OneToOne
    private Department department;

    @Column(name="release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

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

    @Column(name="avaible")
    private String avaible;

    @Column(name="isAmical")
    private Boolean isAmical;


    public Topo(){}

    public Topo(String name, User user, Department department, Date releaseDate, String description, String nearestCity, Boolean carAccess, Boolean carParking, String accessDescription, String nearestHospital, String supplyComment, String avaible) {
        this.name = name;
        this.user = user;
        this.department = department;
        this.releaseDate = releaseDate;
        this.description = description;
        this.nearestCity = nearestCity;
        this.carAccess = carAccess;
        this.carParking = carParking;
        this.accessDescription = accessDescription;
        this.nearestHospital = nearestHospital;
        this.supplyComment = supplyComment;
        this.avaible = avaible;
    }

    public Topo(Long id, String name, User user, Department department, Date releaseDate, String description, String nearestCity, Boolean carAccess, Boolean carParking, String accessDescription, String nearestHospital, String supplyComment, String avaible, Boolean isAmical) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.department = department;
        this.releaseDate = releaseDate;
        this.description = description;
        this.nearestCity = nearestCity;
        this.carAccess = carAccess;
        this.carParking = carParking;
        this.accessDescription = accessDescription;
        this.nearestHospital = nearestHospital;
        this.supplyComment = supplyComment;
        this.avaible = avaible;
        this.isAmical = isAmical;
    }
}
