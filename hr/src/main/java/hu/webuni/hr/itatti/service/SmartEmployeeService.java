package hu.webuni.hr.itatti.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import hu.webuni.hr.itatti.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService  {

	@Override
	public int getPayRaisePercent(Employee employee) {
		
		double workYear = LocalDateTime.now().getYear()-employee.getBegin().getYear();

		if (workYear < 2.5) return 0;
		else if (workYear < 5) return 2;
		else if (workYear < 10) return 5;
		else return 10;
	}

}
