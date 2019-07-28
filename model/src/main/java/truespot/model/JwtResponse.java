package truespot.model;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ApiModel(value = "JwtResponse")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
public class JwtResponse implements Serializable {


    private String accessToken;
    private String type;
    private String pseudo;
    private String[] authorities;

    public JwtResponse() {
    }
}
