package com.plsql;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    String updateEmployee(Long id, String name, String email, Double salary);
    String addEmployee(String name, String email, Double salary);
    String deleteEmployee(Long id);   // <--- new

}
