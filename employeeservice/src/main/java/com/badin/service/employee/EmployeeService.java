package com.badin.service.employee;

import com.badin.service.department.Department;
import com.badin.service.department.DepartmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentClient departmentClient;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addNewEmployee(Employee employee) throws Exception {
        Department department = departmentClient.findByDepartmentId(employee.departmentId);
        if(department == null){
            throw new Exception("Department not found");
        }
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
