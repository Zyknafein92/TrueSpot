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

    @GetMapping(value="/department")
    public List<Department> getDepartments(){
        return departmentManager.findAllDepartment();
    }

    @GetMapping(value="/department/{id}")
    public DepartmentDTO getDepartment(@PathVariable Long id) { return departmentManager.getDepartment(id); }

}
