package com.portal.employee.service;

import com.portal.employee.dto.EmployeeDTO;
import com.portal.employee.model.Employee;
import com.portal.employee.repository.IEmployeeRepository;
import com.portal.employee.utility.EmployeePortalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmployeeServiceTests {

    @Mock
    private IEmployeeRepository employeeRepository;

    @InjectMocks
    private IEmployeeService employeeService = new EmployeeService();

    @Test
    public void getEmployeeTest() throws EmployeePortalException {
        Employee employee = new Employee(111, "John", "Doe", 26, 250000.00, "testOrg");
        Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));

        EmployeeDTO employeeDTO = employeeService.getEmployee(111);

        Assertions.assertNotNull(employeeDTO);
        Assertions.assertEquals(employeeDTO.getId(), employee.getId());
    }

    @Test
    public void getAllEmployeeTest() throws EmployeePortalException {
        Employee employee1 = new Employee(111, "John", "Doe", 26, 250000.00, "testOrg");
        Employee employee2 = new Employee(112, "John", "Doe", 26, 250000.00, "testOrg");
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(employee1, employee2));

        List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployee();

        Assertions.assertFalse(employeeDTOs.isEmpty());
        Assertions.assertTrue(employeeDTOs.size() == 2);
    }

    @Test
    public void createEmployeeTest() throws EmployeePortalException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeService.createEmployee(employeeDTO);
        Mockito.verify(employeeRepository).save(Mockito.any());
    }

    @Test
    public void updateEmployeeTest() throws EmployeePortalException {
        Employee employee = new Employee(111, "John", "Doe", 26, 250000.00, "testOrg");
        Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));

        employeeService.updateEmployee(111,420000.00);

        Mockito.verify(employeeRepository).save(Mockito.any());
    }

    @Test
    public void deleteEmployeeTest() throws EmployeePortalException {
        Employee employee = new Employee(111, "John", "Doe", 26, 250000.00, "testOrg");
        Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));

        employeeService.deleteEmployee(employee.getId());

        Mockito.verify(employeeRepository).deleteById(Mockito.any());
    }
}
