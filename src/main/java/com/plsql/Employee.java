package com.plsql;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.getAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.getById", query = "SELECT e FROM Employee e WHERE e.id = :id")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Double salary;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
