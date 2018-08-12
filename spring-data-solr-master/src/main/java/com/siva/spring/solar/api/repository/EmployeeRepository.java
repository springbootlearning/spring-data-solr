package com.siva.spring.solar.api.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.siva.spring.solar.api.model.Employee;

public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer>{

	Employee findByName(String name);

}
