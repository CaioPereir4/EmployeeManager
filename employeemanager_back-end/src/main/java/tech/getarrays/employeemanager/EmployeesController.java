package tech.getarrays.employeemanager;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok().body(employeeService.findAllEmployees());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee, UriComponentsBuilder uriComponentsBuilder){
        Employee newEmployee = employeeService.addEmployee(employee);
        var uri = uriComponentsBuilder.path("/employee/find/{id}").buildAndExpand(newEmployee.getId()).toUri();
        return ResponseEntity.created(uri).body(newEmployee);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.ok().body(updateEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


}
