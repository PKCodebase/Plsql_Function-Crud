package com.plsql;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String email,
                         @RequestParam Double salary) {
        return service.updateEmployee(id, name, email, salary);
    }


    @PostMapping("/add")
    public String add(@RequestParam String name,
                      @RequestParam String email,
                      @RequestParam Double salary) {
        return service.addEmployee(name, email, salary);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }

}
