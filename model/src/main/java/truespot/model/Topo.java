package truespot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // ajout fetch
    private User user;

    @OneToOne
    private Department department;

    public Topo(){}

    public Topo(String name, User user, Department department) {
        this.name = name;
        this.user = user;
        this.department = department;
    }
}
