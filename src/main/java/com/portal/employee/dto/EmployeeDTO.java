package com.portal.employee.dto;

import com.portal.employee.model.Employee;

public class EmployeeDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Double ctc;
    private String organization;

    public EmployeeDTO() {

    }

    public EmployeeDTO(Integer id, String firstName, String lastName, Integer age, Double ctc, String organization) {
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

    public static EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getCtc(), employee.getOrganization());
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", CTC=" + ctc +
                ", organization='" + organization + '\'' +
                '}';
    }
}
