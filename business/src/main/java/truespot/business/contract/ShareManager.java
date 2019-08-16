package truespot.business.contract;

import truespot.business.dto.ShareDTO;
import truespot.model.Share;

import java.util.List;

public interface ShareManager {

    List<Share> findAllShare();

    Share getShare(Long id);

    Share saveShare(ShareDTO shareDTO);

    void updateShare(Long id, Share share);

    void deleteShare(Long id);
}
