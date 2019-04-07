package truespot.business.contract;


import org.springframework.beans.factory.annotation.Autowired;
import truespot.consumer.contract.DaoFactory;

public abstract class BusinessManager {

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    @Autowired
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
