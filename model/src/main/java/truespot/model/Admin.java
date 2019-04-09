package truespot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin", schema="public")
public class Admin implements Serializable {

    @Id
    @Column(name = "admin_id")
    private long id;

    @Column(name="user_id")
    private Users user;

    protected Admin() {
    }
}