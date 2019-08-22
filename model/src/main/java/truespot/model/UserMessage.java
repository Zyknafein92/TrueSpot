package truespot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "topo_id", referencedColumnName = "topo_id", nullable = false)
    private Topo topo;

    @Column(name="message")
    private String message;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public UserMessage() {}

}
