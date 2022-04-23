package hu.webuni.hr.itatti.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

public class EmployeeDto {
	
	private long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String position;
	@Positive
	private int salary;
	@Past
	private LocalDateTime begin;
	
	private CompanyDto company;
	
	public EmployeeDto() {
		
	}
	
	public EmployeeDto(Long id, String name, String position, int salary, LocalDateTime begin) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.begin = begin;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDateTime getBegin() {
		return begin;
	}
	public void setBegin(LocalDateTime begin) {
		this.begin = begin;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	

}
