package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.DepartmentManager;
import truespot.model.Department;
import truespot.webapp.dto.DepartmentDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentManager departmentManager;

    @GetMapping(value="/department")
    public List<Department> getDepartments(){
        return departmentManager.findAllDepartment();
    }

    @GetMapping(value="/department/{id}")
    public DepartmentDTO getDepartment(@PathVariable Long id) {
        Optional<Department> department = departmentManager.getDepartment(id);
        if(department.isPresent()){
            Department departmentReal = department.get();
            DepartmentDTO departmentDTO = new DepartmentDTO();

            departmentDTO.setName(departmentReal.getName());
            departmentDTO.setNumber(departmentReal.getNumber());

            return departmentDTO;
        }throw new RuntimeException("department not found");
    }


    @PostMapping(value="/department")
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO){

        Department department = new Department();

        department.setName(departmentDTO.getName());
        department.setNumber(departmentDTO.getNumber());

        department = departmentManager.saveDepartment(department);
        departmentDTO.setId(department.getId());
        return departmentDTO;
    }


    @PutMapping(value = "/department/{id}")
    public void updateDepartment(@PathVariable Long id , @RequestBody Department department) {
        departmentManager.updateDepartment(id,department);
    }


    @DeleteMapping(value= "/department/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentManager.deleteDepartment(id);
    }

}
