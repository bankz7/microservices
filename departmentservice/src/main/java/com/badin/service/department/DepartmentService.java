package com.badin.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department findByDepartmentId(Integer id) {
       return departmentRepository.findById(id).orElse(null);
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartmentById(Integer id, Department department) {
        departmentRepository.findById(id).ifPresent(d -> department.setDepartmentId(d.departmentId));
        return departmentRepository.save(department);
    }


}
