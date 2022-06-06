package com.badin.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(Integer id, Employee employee) {
        employeeRepository.findById(id).ifPresent(e -> employee.setEmployeeId(e.getEmployeeId()));
        return employeeRepository.save(employee);
    }

    public List<Employee> findEmployeeByDepartmentId(Integer departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> findEmployeeByOrganizationId(Integer organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }
}
