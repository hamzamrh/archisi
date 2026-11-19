package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Employee;

import java.util.List;

public interface IEmployeeServices {
    Employee getById(long id);
    Employee add(Employee employee);
    Employee update(Employee employee);
    void deleteById(Long id);
    List<Employee> findAll();
}
