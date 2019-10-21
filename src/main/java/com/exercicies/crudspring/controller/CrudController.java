package com.exercicies.crudspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicies.crudspring.business.CrudBO;
import com.exercicies.crudspring.exception.EmptyListException;
import com.exercicies.crudspring.helpers.ConstantsHelpers;
import com.exercicies.crudspring.model.Employee;
import com.exercicies.crudspring.services.CrudService;

@RestController
@RequestMapping("service")
public class CrudController {

	@Autowired
	CrudService service;

	private CrudBO bo = new CrudBO();

	@PostMapping("/create")
	public ResponseEntity<String> create(@Valid @RequestBody Employee employee) {
		try {
			service.create(employee);
			return new ResponseEntity<String>(ConstantsHelpers.SUCCESSFULLY_CREATE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(ConstantsHelpers.CREATE_GENERIC_ERROR, HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> remove(@PathVariable Long id) {
		try {
			Employee employee = service.findById(id);
			service.remove(employee);
			return new ResponseEntity<String>(ConstantsHelpers.SUCCESSFULLY_REMOVE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(ConstantsHelpers.REMOVE_GENERIC_ERROR, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/remove-username/{username}")
	public ResponseEntity<String> removeByUsername(@PathVariable String username) {
		service.remove(service.findByUsername(username));
		return new ResponseEntity<String>(ConstantsHelpers.SUCCESSFULLY_REMOVE, HttpStatus.OK);
	}

	@DeleteMapping("/remove-cof/{cpf}")
	public ResponseEntity<String> removeByCpf(@PathVariable String cpf) {
		service.remove(service.findByCpf(cpf));
		return new ResponseEntity<String>(ConstantsHelpers.SUCCESSFULLY_REMOVE, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@Valid @RequestBody Employee employee) {
		try {
			service.update(employee);
			return new ResponseEntity<String>(ConstantsHelpers.SUCCESSFULLY_UPDATE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(ConstantsHelpers.UPDATE_GENERIC_ERROR, HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@GetMapping("/select-all")
	public ResponseEntity<List<Employee>> selectAll() throws EmptyListException {
		try {
			bo.emptyListVerify(service.selectAll());
			return new ResponseEntity<List<Employee>>(service.selectAll(), HttpStatus.OK);
		} catch (EmptyListException e) {
			throw new EmptyListException(e.getMessage());
		}
	}

	@GetMapping("/select-username/{username}")
	public Employee selectByUsername(@PathVariable String username) {
		return service.findByUsername(username);
	}

	@GetMapping("/select-cpf/{cpf}")
	public Employee selectByCpf(@PathVariable String cpf) {
		return service.findByCpf(cpf);
	}

}
