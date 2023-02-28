package com.portal.employee.service;

import com.portal.employee.dto.EmployeeDTO;
import com.portal.employee.model.Employee;
import com.portal.employee.repository.IEmployeeRepository;
import com.portal.employee.utility.EmployeePortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    public EmployeeDTO getEmployee(Integer id) throws EmployeePortalException {
        Optional<Employee> opt = employeeRepository.findById(id);
        Employee emp = opt.orElseThrow(() -> new EmployeePortalException("No employee found with id: " + id));
        return EmployeeDTO.convertToDTO(emp);
    }

    public List<EmployeeDTO> getAllEmployee() throws EmployeePortalException {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = EmployeeDTO.convertToDTO(employee);
            employeeDTOS.add(employeeDTO);
        }
        if (employeeDTOS.isEmpty())
            throw new EmployeePortalException("No employees found");
        return employeeDTOS;
    }

    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.convertToEntity(employeeDTO);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Integer id, Double ctc) throws EmployeePortalException {
        EmployeeDTO employeeDTO = getEmployee(id);
        employeeDTO.setCtc(ctc);
        Employee employee = Employee.convertToEntity(employeeDTO);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) throws EmployeePortalException {
        EmployeeDTO employeeDTO = getEmployee(id);
        employeeRepository.deleteById(employeeDTO.getId());
    }

}
