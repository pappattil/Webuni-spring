package hu.webuni.hr.itatti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.itatti.config.HrConfigProperties;
import hu.webuni.hr.itatti.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {
	
	@Autowired
	HrConfigProperties config;
	
	@Override
	public int getPayRaisePercent(Employee employee) {
	
		return (int)config.getSalary().getDef().getPercent();
	}

}
