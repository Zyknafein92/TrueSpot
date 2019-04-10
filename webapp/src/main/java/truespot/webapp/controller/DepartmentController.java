package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import truespot.business.contract.DepartmentManager;
import truespot.model.Department;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentManager departmentManager;

    @GetMapping(value="/department")
    public List<Department> getDepartment(){

        return departmentManager.findAllDepartment();
    }

}
