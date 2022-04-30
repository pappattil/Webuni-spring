package hu.webuni.hr.itatti.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.hr.itatti.dto.EmployeeDto;
import hu.webuni.hr.itatti.mapper.EmployeeMapper;
import hu.webuni.hr.itatti.model.Employee;
import hu.webuni.hr.itatti.repository.EmployeeRepository;
import hu.webuni.hr.itatti.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<EmployeeDto> getAll(@RequestParam(required = false) Integer minSalary){
		List<Employee> employees = null;
		if (minSalary == null) {
			employees = employeeService.finAll();
		}else{
			employees = employeeRepository.findBySalaryGreaterThan(minSalary);
		}
		return employeeMapper.employeesToDtos(employees);
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getById(@PathVariable long id){
		Employee employee= findByIdOrThrow(id);
		return employeeMapper.employeeToDto(employee);
	}
	
private Employee findByIdOrThrow(long id) {
		return employeeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public EmployeeDto createEmployee(@RequestBody @Valid EmployeeDto employeedto) {
		return employeeMapper.employeeToDto(employeeService.save(employeeMapper.dtoToEmployee(employeedto)));
		
	}
	@PutMapping("/{id}")
	public ResponseEntity <EmployeeDto> modifyEmployee(@PathVariable long id, @RequestBody @Valid EmployeeDto employeedto) {
		employeedto.setId(id);
		Employee updatedEmployee = employeeService.update(employeeMapper.dtoToEmployee(employeedto));
		if(updatedEmployee==null) {
			return ResponseEntity.notFound().build();
		}else return ResponseEntity.ok(employeeMapper.employeeToDto(updatedEmployee));
	}
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.delete(id);
	}
}
