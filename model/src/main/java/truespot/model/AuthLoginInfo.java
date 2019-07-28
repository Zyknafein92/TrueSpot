package truespot.model;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ApiModel(value = "AuthLoginInfo")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
public class AuthLoginInfo {

    private String pseudo;

    private String password;

    public AuthLoginInfo(){}

    public AuthLoginInfo(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }
}
