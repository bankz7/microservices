package com.badin.service.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id"})})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    public int employeeId;

    @Column(name = "employee_name")
    public String name;

    @Column(name = "position")
    public String position;

    @Column(name = "organization_id")
    public Integer organizationId;

    @Column(name = "department_id")
    public Integer departmentId;
}