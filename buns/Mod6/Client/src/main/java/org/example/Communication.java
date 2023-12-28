package org.example;

import org.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/hw6_war_exploded/api/employees";

    // Fetch all employees from the server
    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
                URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
        return responseEntity.getBody();
    }

    // Fetch an employee by ID from the server
    public Employee getEmployeeById(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    // Save a new or update an existing employee to the server
    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID - " + id + " was updated");
        }
    }

    // Delete an employee from the server by ID
    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID - " + id + " was deleted");
    }
}
