package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
   EmployeeRepository repository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString()); // Criando o código do Empregado
        return repository.save(employee);

    }

    public List<Employee> findAllEmployees(){
        return repository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id){
        return repository.findById(id);
    }

    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
