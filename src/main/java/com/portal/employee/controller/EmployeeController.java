package com.portal.employee.controller;

import com.portal.employee.dto.EmployeeDTO;
import com.portal.employee.service.IEmployeeService;
import com.portal.employee.service.Producer;
import com.portal.employee.utility.EmployeePortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private Producer producer;

    @GetMapping(value = "/details/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) throws Exception {
        EmployeeDTO emp = employeeService.getEmployee(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws Exception {
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/details")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>("Created Employee with ID: " + employeeDTO.getId(), HttpStatus.CREATED);
    }

    @PutMapping(value = "details/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestParam Double ctc) throws EmployeePortalException {
        employeeService.updateEmployee(id, ctc);
        producer.sendMessage("Employee CTC updated");
        return new ResponseEntity<>("Updated Employee CTC details with ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/details/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) throws EmployeePortalException {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted Employee details with ID: " + id, HttpStatus.OK);
    }
}
