package com.portal.employee.repository;

import com.portal.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEmployeeRepository extends MongoRepository<Employee, Integer> {

}
