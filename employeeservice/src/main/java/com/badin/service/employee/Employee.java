package com.badin.service.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account", uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id"})})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "organization_id")
    private Integer organizationId;

    @Column(name = "department_id")
    private Integer departmentId;
}