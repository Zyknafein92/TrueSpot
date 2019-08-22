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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_owner_id", referencedColumnName = "user_id", nullable = false)
    private User userOwner;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_receiver_id", referencedColumnName = "user_id", nullable = false)
    private User userReceiver;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "topo_id", referencedColumnName = "topo_id", nullable = false)
    private Topo topo;

    public Share() {}

    public Share(User userOwner, User userReceiver, Topo topo) {
        this.userOwner = userOwner;
        this.userReceiver = userReceiver;
        this.topo = topo;
    }
}
