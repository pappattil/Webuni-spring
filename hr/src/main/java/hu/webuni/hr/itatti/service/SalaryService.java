package hu.webuni.hr.itatti.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.itatti.model.Employee;


@Service
public class SalaryService {
	
	private EmployeeService employeeService;
	
	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public int setNextMonthSalary(Employee employee) {
		return (int)(employeeService.getPayRaisePercent(employee)*0.01*employee.getSalary())+employee.getSalary();
	}
}
