package com.ci2.sgth.people.application.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci2.sgth.people.application.repository.EmployeeRepository;
import com.ci2.sgth.people.application.service.EmployeeService;
import com.ci2.sgth.people.domain.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeRepository;
	
	@Override
	public Employee saveApplicantFirstInformation(Employee employee) {
		
		employee.setEntrevistado(true);
		return employeRepository.save(employee);
	}
	
	@Override
	public Employee updateApplicantFirstInformation(Employee employee) {
		
		
		return employeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllApplicantsInformation() {
		
		return employeRepository.findAll();
	}
	
	@Override
	public Employee getApliccant(Long idEmployee) {
		return employeRepository.findById(idEmployee).orElseThrow(
					()->new EntityNotFoundException("Empleado no encontrado")
				);
	}
	
	@Override
	public void deleteEmployee(Long idEmployee) {
		
		 employeRepository.deleteById(idEmployee);;
	}

}
