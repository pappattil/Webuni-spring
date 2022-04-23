package hu.webuni.hr.itatti.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	model.put("newEmployee", new Employee());
		return "index";	
	}
	
	@PostMapping("/")
	public String addEmployee(Employee employee){
		allEmployee.add(employee);
		return "redirect:/";
	
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable long id){
		allEmployee.removeIf(e -> e.getId().equals(id));
		return "redirect:/";
	
	}
	@GetMapping("/{id}")
	public String editEmployee(@PathVariable long id,Map<String, Object> model){
		Employee selectedEmployee = allEmployee.stream().filter(e -> e.getId().equals(id)).findFirst().get();
		model.put("employee", selectedEmployee);
		
		return "/editEmployee";
	
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(Employee employee){
		for(int i=0; i< allEmployee.size(); i++) {
			if(allEmployee.get(i).getId().equals(employee.getId())) {
				allEmployee.set(i, employee);
				break;
		}
	}
		return "redirect:/";
	
	}
	
}
