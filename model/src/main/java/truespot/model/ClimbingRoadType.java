package truespot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="climbing_road_type",schema="public" )
public class  ClimbingRoadType implements Serializable {

//    BLOC( null,"Bouldering", "Bloc"),
//    VOIE(null,"Road","Voie"),
//    GRANDEVOIE(null,"Big Road","Grande voie"),
//    RELAIS(null,"Multi-Pich climbing","Relais"),
//    FREE(null,"Free climbing","Escalade libre"),
//    DEEPWATER(null,"DeepWater","Escalade maritime");


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;




}

