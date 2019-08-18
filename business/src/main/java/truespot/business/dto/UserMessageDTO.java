package truespot.business.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserMessageDTO {

    private Long id;
    private Long idTopo;
    private Long idUser;
    private String message;
    private Date date;

}
