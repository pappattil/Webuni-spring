package hu.webuni.hr.itatti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.itatti.model.Employee;
import hu.webuni.hr.itatti.repository.EmployeeRepository;

@Service
public abstract class AbstractEmployeeService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		if (!employeeRepository.existsById(employee.getId())) return null;
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> finAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void delete(long id) {
	employeeRepository.deleteById(id);		
	}
	
	

}
