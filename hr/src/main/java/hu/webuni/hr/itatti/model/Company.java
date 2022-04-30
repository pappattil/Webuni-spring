package hu.webuni.hr.itatti.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int number;
	private String name;
	private String address;
	@OneToMany(mappedBy="company")
	private List<Employee> employees;
	
	public Company() {
	}
	
	
	public Company(Long id, int number, String name, String address, List<Employee> employees) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.address = address;
		this.employees = employees;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		employee.setCompany(this);
		if(this.employees == null) this.employees = new ArrayList<>();
		this.employees.add(employee);
	}

}
