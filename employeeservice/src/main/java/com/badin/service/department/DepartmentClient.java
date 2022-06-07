package com.badin.service.department;

import com.badin.service.employee.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("department-service")
public interface DepartmentClient {
    @GetMapping("/departments/{departmentId}")
    Department findByDepartmentId(@PathVariable Integer departmentId);
}