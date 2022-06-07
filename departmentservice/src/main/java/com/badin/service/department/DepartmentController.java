package com.badin.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> findDepartment() {
        return departmentService.findAllDepartment();
    }

    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable Integer id) {
        return departmentService.findByDepartmentId(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addNewDepartment(department);
    }

    @PutMapping("/{id}")
    public Department editDepartment(@PathVariable Integer id, @RequestBody Department department) {
        return departmentService.updateDepartmentById(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartmentById(id);
    }

}
