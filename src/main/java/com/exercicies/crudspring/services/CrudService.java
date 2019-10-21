package com.exercicies.crudspring.services;

import java.util.List;

import com.exercicies.crudspring.model.Employee;

public interface CrudService {
	
	void create(Employee employee);
	void remove(Employee employee);
	void update(Employee employee);
	List<Employee> selectAll();
	Employee findById(Long id);
	Employee findByUsername(String username);
	Employee findByCpf(String cpf);
	Employee findByEmail(String email);
}
