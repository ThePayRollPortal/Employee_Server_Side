package com.portal.employee.controller;

import com.portal.employee.dto.EmployeeDTO;
import com.portal.employee.service.IEmployeeService;
import com.portal.employee.service.Producer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class EmployeeControllerTests {

    @Mock
    private IEmployeeService employeeService;

    @Mock
    private Producer producer;

    @InjectMocks
    private EmployeeController employeeController = new EmployeeController();

    @Test
    public void getEmployeeTest() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(111, "John", "Doe", 26, 250000.00, "testOrg");
        Mockito.when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(employeeDTO);

        ResponseEntity<EmployeeDTO> response = employeeController.getEmployee(employeeDTO.getId());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(employeeDTO.getId(), response.getBody().getId());
    }

    @Test
    public void getAllEmployeesTest() throws Exception {
        EmployeeDTO employeeDTO1 = new EmployeeDTO(111, "John", "Doe", 26, 250000.00, "testOrg");
        EmployeeDTO employeeDTO2 = new EmployeeDTO(111, "John", "Doe", 26, 250000.00, "testOrg");
        Mockito.when(employeeService.getAllEmployee()).thenReturn(List.of(employeeDTO1, employeeDTO2));

        ResponseEntity<List<EmployeeDTO>> response = employeeController.getAllEmployees();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertFalse(response.getBody().isEmpty());
        Assertions.assertTrue(response.getBody().size() == 2);
    }

    @Test
    public void createEmployeeTest() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(111, "John", "Doe", 26, 250000.00, "testOrg");

        ResponseEntity<String> response = employeeController.createEmployee(employeeDTO);

        Mockito.verify(employeeService).createEmployee(employeeDTO);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("Created Employee with ID: " + employeeDTO.getId(), response.getBody());
    }

    @Test
    public void updateEmployeeTest() throws Exception {
        Integer id = 111;
        Double ctc = 22000.00;
        Mockito.doNothing().when(producer).sendMessage(Mockito.anyString());

        ResponseEntity<String> response = employeeController.updateEmployee(id, ctc);

        Mockito.verify(employeeService).updateEmployee(id, ctc);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Updated Employee CTC details with ID: " + id, response.getBody());
    }

    @Test
    public void deleteEmployeeTest() throws Exception {
        Integer id = 111;
        ResponseEntity<String> response = employeeController.deleteEmployee(id);

        Mockito.verify(employeeService).deleteEmployee(id);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Deleted Employee details with ID: " + id, response.getBody());
    }

}
