package hu.webuni.hr.itatti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.itatti.service.DefaultEmployeeService;
import hu.webuni.hr.itatti.service.EmployeeService;

@Configuration
@Profile("!smart")
public class EmployeeConfiguration {
	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
	}
}
