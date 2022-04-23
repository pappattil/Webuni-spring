package hu.webuni.hr.itatti.web;

import java.util.List;
import java.util.NoSuchElementException;

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

import hu.webuni.hr.itatti.dto.CompanyDto;
import hu.webuni.hr.itatti.dto.EmployeeDto;
import hu.webuni.hr.itatti.mapper.CompanyMapper;
import hu.webuni.hr.itatti.mapper.EmployeeMapper;
import hu.webuni.hr.itatti.model.Company;
import hu.webuni.hr.itatti.model.Employee;
import hu.webuni.hr.itatti.service.CompanyService;
import hu.webuni.hr.itatti.service.EmployeeService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private  CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public List<CompanyDto> getAll(@RequestParam(required = false) Boolean full){
		List<Company> companies = companyService.finAll();
		if(isFull(full)) {
			return companyMapper.companiesToDtos(companies);
		}else return companyMapper.companiesToDtosNoEmployees(companies);
	}

	private boolean isFull(Boolean full) {
		return full != null && full;
	}

	@GetMapping("/{id}")
	public CompanyDto getById(@PathVariable long id,@RequestParam(required = false) Boolean full){
		Company company = companyService.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if(isFull(full)) {
			return companyMapper.companyToDto(company);
		}else return companyMapper.companyToDtoNoEmployees(company);
	}
	
	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto companyDto) {
		return companyMapper.companyToDto(companyService.save(companyMapper.dtoToCompany(companyDto)));
		
	}
	@PutMapping("/{id}")
	public ResponseEntity <CompanyDto> modifyCompany(@PathVariable long id, @RequestBody CompanyDto companyDto) {
		companyDto.setCopmpanyId(id);
		Company updatedCompany= companyService.update(companyMapper.dtoToCompany(companyDto));
		if(updatedCompany==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(companyMapper.companyToDto(updatedCompany));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyService.delete(id);
	}
	
	@PostMapping("/{id}/employee")
	public CompanyDto addEmployeeToCompany(@PathVariable long id, @RequestBody EmployeeDto employee) {
		try {
			return companyMapper.companyToDto(companyService.addEmployee(id, employeeMapper.dtoToEmployee(employee)));
		}catch(NoSuchElementException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}/employee/{employeeId}")
	public CompanyDto deleteEmployee(@PathVariable long id, @PathVariable long employeeId) {
		try {
			return companyMapper.companyToDto(companyService.deleteEmployee(id, employeeId));
		}catch(NoSuchElementException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/employee")
	public CompanyDto replaceAllEmployees(@PathVariable long id, @RequestBody List<EmployeeDto> employees) {
		try {
			return companyMapper.companyToDto(companyService.replaceEmployees(id, employeeMapper.dtosToEmployees(employees)));
		}catch(NoSuchElementException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/payRaise")
	public int getPayRaisePercent(@RequestBody Employee employee) {
			return employeeService.getPayRaisePercent(employee);
		}
	
}
