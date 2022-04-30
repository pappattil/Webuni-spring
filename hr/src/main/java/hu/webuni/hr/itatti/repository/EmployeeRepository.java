package hu.webuni.hr.itatti.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.hr.itatti.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findBySalaryGreaterThan(Integer minSalary);
	
	List<Employee> findByPosition(String position);
	
	List<Employee> findByNameStartingWithIgnoreCase(String name);
	
	List<Employee> findByBeginBetween(LocalDateTime start, LocalDateTime end);
	
	
	
}
