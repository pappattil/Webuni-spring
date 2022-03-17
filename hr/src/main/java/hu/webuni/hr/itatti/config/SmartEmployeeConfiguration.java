package hu.webuni.hr.itatti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.itatti.service.EmployeeService;
import hu.webuni.hr.itatti.service.SmartEmployeeService;

@Configuration
@Profile("smart")
public class SmartEmployeeConfiguration {
	@Bean
	public EmployeeService employeeService() {
		return new SmartEmployeeService();
	}
}
