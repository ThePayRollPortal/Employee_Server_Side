package com.portal.employee.model;

import com.portal.employee.dto.EmployeeDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Double ctc;
    private String organization;

    public Employee(){

    }

    public Employee(Integer id, String firstName, String lastName, Integer age, Double ctc, String organization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ctc = ctc;
        this.organization = organization;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getCtc() {
        return ctc;
    }

    public void setCtc(Double ctc) {
        this.ctc = ctc;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public static Employee convertToEntity(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getAge(), employeeDTO.getCtc(), employeeDTO.getOrganization());
    }

}
