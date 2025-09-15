package com.plsql;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeFunctionRepository repo;

    public EmployeeServiceImpl(EmployeeFunctionRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.getEmployeeById(id);
    }

    @Override
    public String updateEmployee(Long id, String name, String email, Double salary) {
        return repo.updateEmployee(id, name, email, salary);
    }

    @Override
    public String addEmployee(String name, String email, Double salary) {
        return repo.addEmployee(name, email, salary);
    }
}
