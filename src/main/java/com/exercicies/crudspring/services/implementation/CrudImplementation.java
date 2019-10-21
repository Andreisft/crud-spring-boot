package com.exercicies.crudspring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicies.crudspring.model.Employee;
import com.exercicies.crudspring.repository.EmployeeRepository;
import com.exercicies.crudspring.services.CrudService;

@Service
public class CrudImplementation implements CrudService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public void create(Employee employee) {
		Employee e = new Employee();
		e = employee;
		repository.save(e);
	}

	@Override
	public List<Employee> selectAll()  {
		return repository.findAll();			
	}

	@Override
	public void remove(Employee employee) {
		Employee e = new Employee();
		e = employee;
		repository.delete(e);
	}

	@Override
	public void update(Employee employee) {
		repository.save(employee);
	}

	@Override
	public Employee findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Employee findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	@Override
	public Employee findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Employee findById(Long id) {
		return repository.findById(id);
	}

}
