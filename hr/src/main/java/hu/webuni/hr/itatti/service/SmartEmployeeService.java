package hu.webuni.hr.itatti.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.itatti.config.HrConfigProperties;
import hu.webuni.hr.itatti.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService  {
	
	@Autowired
	HrConfigProperties config;

	@Override
	public int getPayRaisePercent(Employee employee) {
		
		double workYear = LocalDateTime.now().getYear()-employee.getBegin().getYear();

		if (workYear < config.getSalary().getYear().getLow()) return (int)config.getSalary().getPercent().getLow();
		else if (workYear < config.getSalary().getYear().getMid()) return (int)config.getSalary().getPercent().getMid();
		else if (workYear <= config.getSalary().getYear().getHigh()) return (int)config.getSalary().getPercent().getHigh();
		else return (int)config.getSalary().getPercent().getSuperhigh();
		
	}

}
