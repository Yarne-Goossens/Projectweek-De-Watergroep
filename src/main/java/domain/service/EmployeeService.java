package domain.service;

import domain.model.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    void addEmployee(Employee employee);

    Employee findEmployeeWithEmail(String email);

    ArrayList<Employee> getAllEmployees();
}
