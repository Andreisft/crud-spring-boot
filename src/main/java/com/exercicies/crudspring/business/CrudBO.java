package com.exercicies.crudspring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exercicies.crudspring.exception.EmptyListException;
import com.exercicies.crudspring.helpers.ConstantsHelpers;
import com.exercicies.crudspring.model.Employee;
import com.exercicies.crudspring.repository.EmployeeRepository;

public class CrudBO {

	@Autowired
	EmployeeRepository repository;
	
	public void emptyListVerify(List<Employee> employees) throws EmptyListException {
		if (employees.isEmpty()) {
			throw new EmptyListException(ConstantsHelpers.EMPTY_LIST);
		}
	}
	
}
