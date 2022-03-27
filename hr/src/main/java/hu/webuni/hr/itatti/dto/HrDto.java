package hu.webuni.hr.itatti.dto;

import java.time.LocalDateTime;

public class HrDto {
	
	private Long id;
	private String name;
	private String position;
	private int salary;
	private LocalDateTime begin;
	
	public HrDto() {
		
	}
	
	public HrDto(Long id, String name, String position, int salary, LocalDateTime begin) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.begin = begin;
	}
	
	
	public Long getId() {
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
	

}
