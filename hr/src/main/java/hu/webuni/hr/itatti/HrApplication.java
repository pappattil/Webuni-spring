package hu.webuni.hr.itatti;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.itatti.model.Employee;
import hu.webuni.hr.itatti.service.SalaryService;


@SpringBootApplication
public class HrApplication implements CommandLineRunner{

	@Autowired
	SalaryService salaryService;
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee(1L, "Öreg József", "Raktárvezető", 400000, LocalDateTime.of(1993,05,01,13,00));
		Employee employee2 = new Employee(2L, "Farkas Piroska", "Irodavezető", 400000, LocalDateTime.of(2014,01,01,10,00));
		Employee employee3 = new Employee(3L, "Jóska István", "Operátor", 400000, LocalDateTime.of(2018,05,01,13,00));
		Employee employee4 = new Employee(4L, "Fiatal Ödön", "Adminisztrátor", 400000, LocalDateTime.of(2021,01,01,10,00));
	
		System.out.println(employee1.getName()+": "+salaryService.setNextMonthSalary(employee1));
		System.out.println(employee2.getName()+": "+salaryService.setNextMonthSalary(employee2));
		System.out.println(employee3.getName()+": "+salaryService.setNextMonthSalary(employee3));
		System.out.println(employee4.getName()+": "+salaryService.setNextMonthSalary(employee4));
				
	}

}
