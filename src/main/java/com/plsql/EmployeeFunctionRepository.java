package com.plsql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeFunctionRepository {

    @PersistenceContext
    private EntityManager em;

    // Call get_all_employees()
    public List<Employee> getAllEmployees() {
        return em.createNativeQuery("SELECT * FROM get_all_employees()", Employee.class)
                .getResultList();
    }

    // Call get_employee_by_id(emp_id)
    public Employee getEmployeeById(Long id) {
        return (Employee) em.createNativeQuery("SELECT * FROM get_employee_by_id(:id)", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    // Call update_employee_details()
    @Transactional
    public String updateEmployee(Long id, String name, String email, Double salary) {
        return (String) em.createNativeQuery("SELECT update_employee_details(:id, :name, :email, :salary)")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("email", email)
                .setParameter("salary", salary)
                .getSingleResult();
    }

    // Call add_employee() -> return String instead of void
    @Transactional
    public String addEmployee(String name, String email, Double salary) {
        return (String) em.createNativeQuery("SELECT add_employee(:name, :email, :salary)")
                .setParameter("name", name)
                .setParameter("email", email)
                .setParameter("salary", salary)
                .getSingleResult();
    }
}
