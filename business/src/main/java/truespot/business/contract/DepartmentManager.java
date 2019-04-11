package truespot.business.contract;

import truespot.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentManager {

    List<Department> findAllDepartment();

    Optional<Department> getDepartment(Long id);

    Department saveDepartment(Department department);

    void updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);
}
