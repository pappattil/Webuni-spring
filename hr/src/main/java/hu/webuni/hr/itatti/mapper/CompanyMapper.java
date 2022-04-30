package hu.webuni.hr.itatti.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import hu.webuni.hr.itatti.dto.CompanyDto;
import hu.webuni.hr.itatti.dto.EmployeeDto;
import hu.webuni.hr.itatti.model.Company;
import hu.webuni.hr.itatti.model.Employee;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

	List<CompanyDto> companiesToDtos(List<Company> companies);
	@IterableMapping(qualifiedByName = "summary")
	List<CompanyDto> companiesToDtosNoEmployees(List<Company> companies);
	
	CompanyDto companyToDto(Company company);
	Company dtoToCompany (CompanyDto companyDto);
	List<Company> dtosToCompanies(List<CompanyDto> companies);

	EmployeeDto employeeToDto(Employee employee);
	Employee dtoToEmployee (EmployeeDto employeeDto);
	
	@Mapping(target="employees", ignore=true)
	@Named("summary")
	CompanyDto companyToDtoNoEmployees(Company company);
}
