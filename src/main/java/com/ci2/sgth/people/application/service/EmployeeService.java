package com.ci2.sgth.people.application.service;

import java.util.List;

import com.ci2.sgth.people.domain.entity.Employee;

public interface EmployeeService {
	Employee saveApplicantFirstInformation(Employee employee);
	Employee getApliccant(Long idEmployee);
	void deleteEmployee(Long idEmployee);
	List<Employee> getAllApplicantsInformation();
	Employee updateApplicantFirstInformation(Employee employee);
}
