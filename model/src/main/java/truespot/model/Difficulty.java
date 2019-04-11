package truespot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name= "difficulty", schema="public")
public class Difficulty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="difficulty_id")
    private long id;

    // private ClimbingRoad climbingRoad;

    @Column(name="number")
    private int number;

    @Column(name="letter")
    private char letter;

    @Column(name="symbol")
    private char symbol;

    public Difficulty(){}

    public Difficulty(int number, char letter, char symbol) {
        this.number = number;
        this.letter = letter;
        this.symbol = symbol;
    }
}