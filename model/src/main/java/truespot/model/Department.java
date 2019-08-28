package truespot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@ApiModel(value = "Department")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Setter
@Getter
@Entity
@Table(name="department", schema="public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="department_name")
    private String name;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }
}