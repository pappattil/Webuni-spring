package hu.webuni.hr.itatti.service;

import java.util.List;
import java.util.Optional;

import hu.webuni.hr.itatti.model.Employee;

public interface EmployeeService {
	int getPayRaisePercent(Employee employee);
	public Employee save(Employee employee);
	public Employee update(Employee employee);
	public List<Employee> finAll();
	public Optional<Employee> findById(long id);
	public void delete(long id);	
}
