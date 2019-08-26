package truespot.business.contract;


import truespot.business.dto.ShareDTO;
import truespot.model.Share;
import truespot.model.Topo;

import java.util.List;

public interface ShareManager {

    List<Share> findAllShare();

    Share getShare(Long id);

    Share saveShare(ShareDTO shareDTO);

    Share findUserShare(Long id);

    void updateShare(Topo topo);

    void deleteShare(Long id);
}
