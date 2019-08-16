package truespot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@ApiModel(value = "UserMessage")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
@Entity
@Table(name="User_message", schema= "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_messsage_id")
    private Long id;

    @Column(name="user_id")
    private User user;

    @Column(name="message")
    private String message;

    public UserMessage() {}

}
