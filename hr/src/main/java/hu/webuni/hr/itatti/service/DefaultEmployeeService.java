package hu.webuni.hr.itatti.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.itatti.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Override
	public int getPayRaisePercent(Employee employee) {
		// TODO Auto-generated method stub
		return 5;
	}

}
