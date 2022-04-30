package hu.webuni.hr.itatti.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
	private long id;
	private String name;
	private int number;
	private String address;
	private List<EmployeeDto> employees = new ArrayList<>();
	
	public CompanyDto() {	
	}
	
	public CompanyDto(long id, String name, int number, String address,
			List<EmployeeDto> employees) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.address = address;
		this.employees = employees;
	}
	
	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}
