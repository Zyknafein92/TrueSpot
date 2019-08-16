package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.ShareManager;
import truespot.business.dto.ShareDTO;
import truespot.model.Share;
import truespot.model.Topo;
import truespot.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class ShareManagerImpl extends BusinessManagerImpl implements ShareManager {

    @Override
    public List<Share> findAllShare() {
        return getDaoFactory().getShareRepository().findAll();
    }

    @Override
    public Share getShare(Long id) {

        Optional<Share> shareOptional = getDaoFactory().getShareRepository().findById(id);
        Share share = null;

        if(shareOptional.isPresent()){

            share = new Share(
                    shareOptional.get().getUserOwner(),
                    shareOptional.get().getUserReceiver(),
                    shareOptional.get().getTopo()
            );
        }

        return share;
    }

    @Override
    public Share saveShare(ShareDTO shareDTO) {

        Topo topo = getDaoFactory().getTopoRepository().getOne(shareDTO.getIdTopo());
        User userOwner = getDaoFactory().getUserRepository().findByPseudo(shareDTO.getIdUserOwner());
        User userReceiver = getDaoFactory().getUserRepository().findByPseudo(shareDTO.getIdUserReceiver());

        Share share = new Share();
        share.setUserOwner(userOwner);
        share.setUserReceiver(userReceiver);
        share.setTopo(topo);

        return getDaoFactory().getShareRepository().save(share);
    }

    @Override
    public void updateShare(Long id, Share share) {
        share.setId(id);
        getDaoFactory().getShareRepository().save(share);
    }

    @Override
    public void deleteShare(Long id) {
        getDaoFactory().getShareRepository().deleteById(id);
    }
}
