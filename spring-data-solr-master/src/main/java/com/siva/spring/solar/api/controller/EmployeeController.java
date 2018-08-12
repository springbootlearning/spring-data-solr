package com.siva.spring.solar.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.siva.spring.solar.api.model.Employee;
import com.siva.spring.solar.api.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@PostConstruct
	public void addEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(373, "siva", new String[] { "Bangalore", "BTM" }));
		employees.add(new Employee(908, "manoj", new String[] { "Hyderbad", "XYZ" }));
		employees.add(new Employee(321, "venkat", new String[] { "Pune", "PQR" }));
		repository.saveAll(employees);
	}

	@GetMapping("/getALL")
	public Iterable<Employee> getEmployees() {
		return repository.findAll();
	}

	@GetMapping("/getEmployee/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return repository.findByName(name);
	}

}
