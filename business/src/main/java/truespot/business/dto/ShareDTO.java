package truespot.business.dto;

import lombok.Data;


@Data
public class ShareDTO {

    private Long id;
    private String idUserOwner;
    private String idUserReceiver;
    private Long idTopo;

}
