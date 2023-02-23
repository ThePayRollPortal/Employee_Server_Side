package com.portal.employee.service;

import com.portal.employee.dto.EmployeeDTO;
import com.portal.employee.utility.EmployeePortalException;

import java.util.List;

public interface IEmployeeService {

    EmployeeDTO getEmployee(Integer id) throws EmployeePortalException;

    List<EmployeeDTO> getAllEmployee() throws EmployeePortalException;

    void createEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(Integer id, Double ctc) throws EmployeePortalException;

    void deleteEmployee(Integer id) throws EmployeePortalException;

}

