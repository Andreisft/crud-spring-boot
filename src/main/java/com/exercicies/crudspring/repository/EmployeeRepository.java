package com.exercicies.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercicies.crudspring.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

	Employee findById(Long id);
	Employee findByUsername(String username); 
	Employee findByCpf(String cpf);
	Employee findByEmail(String email);
	
}
