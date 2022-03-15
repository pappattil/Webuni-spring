package hu.webuni.hr.itatti.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.itatti.model.Employee;


@Service
public class SalaryService {
	
	SmartEmployeeService smartEmployeeService;
	
	public SalaryService(SmartEmployeeService smartEmployee) {
		super();
		this.smartEmployeeService = smartEmployee;
	}
	
	public int setNextMonthSalary(Employee employee) {
		return (int)(smartEmployeeService.getPayRaisePercent(employee)*0.01*employee.getSalary())+employee.getSalary();
	}
}
