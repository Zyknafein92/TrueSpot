package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import truespot.business.contract.DepartmentManager;
import truespot.business.dto.DepartmentDTO;
import truespot.model.Department;

import java.util.List;
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
