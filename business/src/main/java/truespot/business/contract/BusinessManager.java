package truespot.business.contract;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.consumer.contract.DaoFactory;

@Service
public abstract class BusinessManager {

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    @Autowired
     void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
