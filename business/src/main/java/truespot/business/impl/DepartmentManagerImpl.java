package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.DepartmentManager;
import truespot.model.Department;

import java.util.List;

@Service
public class DepartmentManagerImpl extends BusinessManagerImpl implements DepartmentManager {

    @Override
    public List<Department> findAllDepartment() {
        return getDaoFactory().getDepartmentRepository().findAll();
    }
}
