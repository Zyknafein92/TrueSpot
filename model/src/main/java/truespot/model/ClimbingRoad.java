package truespot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClimbingRoad implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "area_id", referencedColumnName = "area_id", nullable = false)
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
    private String letter;

    @Column(name="symbol")
    private String symbol;

    public ClimbingRoad() {

    }

    public ClimbingRoad(String name, String description, String type, int number, String letter, String symbol) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.number = number;
        this.letter = letter;
        this.symbol = symbol;
    }

    public ClimbingRoad(Area area, String name, String description, String type, int number, String letter, String symbol) {
        this.area = area;
        this.name = name;
        this.description = description;
        this.type = type;
        this.number = number;
        this.letter = letter;
        this.symbol = symbol;
    }


}
