package hu.webuni.hr.itatti.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import hu.webuni.hr.itatti.HrApplication;
import hu.webuni.hr.itatti.dto.HrDto;
import hu.webuni.hr.itatti.model.Employee;

@Controller
public class HrTLController {

	private List<Employee> allEmployee = new ArrayList<>();
	
	{
		allEmployee.add(new Employee(1L, "Öreg József", "Raktárvezető", 400000, LocalDateTime.of(1993,5,1,13,0)));
		allEmployee.add(new Employee(2L, "Farkas Piroska", "Irodavezető", 400000, LocalDateTime.of(2014,1,01,10,0)));
		allEmployee.add(new Employee(3L, "Jóska István", "Operátor", 400000, LocalDateTime.of(2019,9,1,10,00)));
		allEmployee.add(new Employee(4L, "Fiatal Ödön", "Adminisztrátor", 400000, LocalDateTime.of(2021,1,1,10,0)));
		
	}

//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
	
	@GetMapping("/")
	public String listEmployee(Map<String, Object> model) {
	model.put("employees", allEmployee);
		return "index";
		
	}
}
