package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IEmployeeRepository;
import tn.esprit.hamzamraihi4ieit.Service.IEmployeeServices;
import tn.esprit.hamzamraihi4ieit.domaine.Employee;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeServices {

    private final IEmployeeRepository iEmployeeRepository;

    @Override
    public Employee getById(long id) {
        return iEmployeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("employee not found"));
    }

    @Override
    public Employee add(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
