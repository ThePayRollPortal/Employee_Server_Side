package com.portal.employee.model;

import com.portal.employee.dto.EmployeeDTO;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Double CTC;
    private String organization;

    public Employee(){

    }

    public Employee(Integer id, String firstName, String lastName, Integer age, Double CTC, String organization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.CTC = CTC;
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

    public Double getCTC() {
        return CTC;
    }

    public void setCTC(Double CTC) {
        this.CTC = CTC;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public static Employee convertToEntity(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getAge(), employeeDTO.getCTC(), employeeDTO.getOrganization());
    }

}
