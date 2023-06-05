package tech.getarrays.employeemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
