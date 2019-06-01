package truespot.business.contract;

import truespot.business.dto.DepartmentDTO;
import truespot.model.Department;

import java.util.List;

public interface DepartmentManager {

    List<Department> findAllDepartment();

    DepartmentDTO getDepartment(Long id);

}
