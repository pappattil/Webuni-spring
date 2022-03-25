package hu.webuni.airport.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.airport.dto.AirportDto;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

	private Map<Long, AirportDto> airports = new HashMap<>();
	{
		airports.put(1L, new AirportDto(1 ,"cghcg" ,"cgh"));
		airports.put(2L, new AirportDto(2 ,"cghcg" ,"cgh"));
		airports.put(3L, new AirportDto(3 ,"cghcg" ,"cgh"));
	}
	@GetMapping
	public List<AirportDto> getAll(){
		return new ArrayList<>(airports.values());
	}
	@GetMapping("/{id}")
	public ResponseEntity<AirportDto> getById(@PathVariable long id){
		AirportDto airportDto = airports.get(id);
		if(airportDto!=null)
			return ResponseEntity.ok(airportDto);
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public AirportDto createAirport(@RequestBody AirportDto airportdto) {
		airports.put(airportdto.getId(), airportdto);
		return airportdto;
		
	}
	@PutMapping("/{id}")
	public ResponseEntity <AirportDto> modifyAirport(@PathVariable long id, @RequestBody AirportDto airportdto) {
		if(!airports.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		airportdto.setId(id);
		airports.put(id, airportdto);
		return ResponseEntity.ok(airportdto);
	}
	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable long id) {
		airports.remove(id);
	}
}
