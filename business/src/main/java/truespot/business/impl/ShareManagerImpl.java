package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.ShareManager;
import truespot.business.contract.TopoManager;
import truespot.business.dto.ShareDTO;
import truespot.model.Share;
import truespot.model.Topo;
import truespot.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class ShareManagerImpl extends BusinessManagerImpl implements ShareManager {

    @Autowired
    TopoManager topoManager;

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
        topo.setAvaible("ATTENTE DE VALIDATION");
        share.setTopo(topo);

        return getDaoFactory().getShareRepository().save(share);
    }

    @Override
    public Share findUserShare(Long id) {
        return getDaoFactory().getShareRepository().findUserShare(id);
    }

    @Override
    public void updateShare(Topo topo) {

        Share share = getDaoFactory().getShareRepository().findShareByTopo(topo.getId());
        Topo topoToSave = share.getTopo();
        topoToSave.setAvaible("EMPRUNTABLE");
        getDaoFactory().getShareRepository().delete(share);
        getDaoFactory().getTopoRepository().save(topoToSave);
    }

    @Override
    public void deleteShare(Long id) {
        getDaoFactory().getShareRepository().delete(getDaoFactory().getShareRepository().getOne(id));
    }
}
