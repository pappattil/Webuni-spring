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
	
	public CompanyDto(long copmpanyId, String companyName, int companyNumber, String companyAddress,
			List<EmployeeDto> employeeList) {
		super();
		this.id = copmpanyId;
		this.name = companyName;
		this.number = companyNumber;
		this.address = companyAddress;
		this.employees = employeeList;
	}
	
	public List<EmployeeDto> getEmployeeList() {
		return employees;
	}

	public void setEmployeeList(List<EmployeeDto> employeeList) {
		this.employees = employeeList;
	}

	public long getCopmpanyId() {
		return id;
	}
	public void setCopmpanyId(long copmpanyId) {
		this.id = copmpanyId;
	}
	public String getCompanyName() {
		return name;
	}
	public void setCompanyName(String companyName) {
		this.name = companyName;
	}
	public int getCompanyNumber() {
		return number;
	}
	public void setCompanyNumber(int companyNumber) {
		this.number = companyNumber;
	}
	public String getCompanyAddress() {
		return address;
	}
	public void setCompanyAddress(String companyAddress) {
		this.address = companyAddress;
	}

	
}
