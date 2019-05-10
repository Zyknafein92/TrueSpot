package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.DepartmentManager;
import truespot.business.dto.mapper.DepartmentMapper;
import truespot.model.Department;
import truespot.business.dto.DepartmentDTO;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentManager departmentManager;
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping(value="/department")
    public List<Department> getDepartments(){
        return departmentManager.findAllDepartment();
    }

    @GetMapping(value="/department/{id}")
    public DepartmentDTO getDepartment(@PathVariable Long id) {
        Optional<Department> department = departmentManager.getDepartment(id);
        if(department.isPresent()){
            Department departmentR = department.get();
            return departmentMapper.objectToDTO(departmentR);
        }throw new RuntimeException("department not found");
    }


    @PostMapping(value="/department")
    public Department createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentMapper.DTOToObject(departmentDTO);
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
