package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.DepartmentManager;
import truespot.model.Department;

import java.util.List;
import java.util.Optional;
//todo : refactor selon area
@Service
public class DepartmentManagerImpl extends BusinessManagerImpl implements DepartmentManager {

    @Override
    public List<Department> findAllDepartment() {
        return getDaoFactory().getDepartmentRepository().findAll();
    }

    @Override
    public Optional<Department> getDepartment(Long id) {
        return getDaoFactory().getDepartmentRepository().findById(id);
    }

    @Override
    public Department saveDepartment(Department department) {
        return getDaoFactory().getDepartmentRepository().save(department);
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        department.setId(id);
       getDaoFactory().getDepartmentRepository().save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        getDaoFactory().getDepartmentRepository().deleteById(id);
    }
}
