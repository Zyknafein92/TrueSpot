package truespot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@ApiModel(value = "Share")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
@Entity
@Table(name="Share", schema= "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="share_id")
    private Long id;

    @Column(name="user_owner_id")
    private User userOwner;

    @Column(name="user_receiver_id")
    private User userReceiver;

    @Column(name="share_id")
    private Topo topo;

    public Share() {}

    public Share(User userOwner, User userReceiver, Topo topo) {
        this.userOwner = userOwner;
        this.userReceiver = userReceiver;
        this.topo = topo;
    }
}
