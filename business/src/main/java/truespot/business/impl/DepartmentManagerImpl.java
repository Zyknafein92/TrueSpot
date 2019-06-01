package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.DepartmentManager;
import truespot.business.dto.DepartmentDTO;
import truespot.business.dto.mapper.DepartmentMapper;
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
    public DepartmentDTO getDepartment(Long id) {

        Optional<Department> departmentOptional = getDaoFactory().getDepartmentRepository().findById(id);

        Department department = null;

        if(departmentOptional.isPresent()){
            department = new Department(
                    departmentOptional.get().getName()
            );
        }
        return department != null ? DepartmentMapper.objectToDTO(department) : null;
    }

}
