package com.voloshyn.spring.rest;

import com.voloshyn.spring.rest.entity.Employee;
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
    private final String URL = "http://localhost:8080/spring_cource_mvs/api/employees";

    public List<Employee> showAllEmployee(){
        ResponseEntity<List<Employee>> response = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>(){});
        List<Employee>allEmployee = response.getBody();
        return allEmployee;
    }

    public Employee getEmployee( int id){
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void save_updateEmployee(Employee employee){
        int id = employee.getId();
        if(id==0){
            ResponseEntity<String> response = restTemplate.postForEntity(URL,employee, String.class);
            System.out.println("New Employee was added to DB ");
            System.out.println(response.getBody());
        } else {
            restTemplate.put(URL,employee);
            System.out.println("Employee with ID " + id + " was updated in DB");
        }

    }
    public void deleteEmployee(int id){
         restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted to DB");
    }


}
