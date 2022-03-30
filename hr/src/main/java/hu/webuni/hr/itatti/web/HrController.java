package hu.webuni.hr.itatti.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import hu.webuni.hr.itatti.dto.HrDto;

@RestController
@RequestMapping("/api/employees")
public class HrController {
	private Map<Long, HrDto> employees = new HashMap<>();
	{
		employees.put(1L, new HrDto(1L, "Öreg József", "Raktárvezető", 420000, LocalDateTime.of(1993,5,1,13,0)));
		employees.put(2L, new HrDto(2L, "Farkas Piroska", "Irodavezető", 415000, LocalDateTime.of(2014,1,01,10,0)));
		employees.put(3L, new HrDto(3L, "Jóska István", "Operátor", 410000, LocalDateTime.of(2019,9,1,10,00)));
		employees.put(4L, new HrDto(4L, "Fiatal Ödön", "Adminisztrátor", 405000, LocalDateTime.of(2021,1,1,10,0)));
	
	}
	@GetMapping
	public List<HrDto> getAll(){
		return new ArrayList<>(employees.values());
	}
	@GetMapping("/{id}")
	public ResponseEntity<HrDto> getById(@PathVariable long id){
		HrDto employeeDto = employees.get(id);
		if(employeeDto!=null)
			return ResponseEntity.ok(employeeDto);
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(params = "minSalary")
	public List<HrDto> getAllMinSalary(@RequestParam int minSalary) {

		return employees.values().stream().filter(e -> e.getSalary() > minSalary).collect(Collectors.toList());
	}
	
	@PostMapping
	public HrDto createEmployee(@RequestBody HrDto employeedto) {
		employees.put(employeedto.getId(), employeedto);
		return employeedto;
		
	}
	@PutMapping("/{id}")
	public ResponseEntity <HrDto> modifyEmployee(@PathVariable long id, @RequestBody HrDto employeedto) {
		if(!employees.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		employeedto.setId(id);
		employees.put(id, employeedto);
		return ResponseEntity.ok(employeedto);
	}
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employees.remove(id);
	}
}
