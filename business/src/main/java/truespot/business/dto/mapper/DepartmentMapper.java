package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.DepartmentManager;
import truespot.business.dto.DepartmentDTO;
import truespot.model.Department;

@Component
public class DepartmentMapper {


    public static DepartmentDTO objectToDTO(Department department){

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setName(department.getName());

        return departmentDTO;
    }

//    public static Department DTOToObject(DepartmentDTO departmentDTO){
//
//        Department department = new Department();
//
//        department.setName(departmentDTO.getName());
//        departmentDTO.setId(department.getId());
//
//        return department;
//    }

}
