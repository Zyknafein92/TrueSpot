package truespot.business.dto;

import lombok.Data;
import truespot.model.Topo;
import truespot.model.User;

import java.util.Date;

@Data
public class UserMessageDTO {

    private Long id;
    private Topo topo;
    private User user;
    private String message;
    private Date date;

}
