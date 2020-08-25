package in.app.onlineassisment.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.app.onlineassisment.Utils.UserNotFoundException;
import in.app.onlineassisment.model.Person;
import in.app.onlineassisment.service.PersonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/person")
	public List<Person> get(){
		return personService.get();
	}
	
	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable int id) {
		Person p= personService.getById(id);
		if(p == null)
			throw new UserNotFoundException("Person id: "+id+" is not found");
		
		
		
		return p;
	}
	
	@GetMapping("/personbycode/{code}")
	public Person getPersonByCode(@PathVariable int code) {
		Person p= personService.getByStudentCode(code);
		if(p == null)
			throw new UserNotFoundException("Person code: "+code+" is not found");
		return p;
	}	
	
	@PostMapping("/person")
	public Person save( @RequestBody Person p) {
		personService.save(p);
		if(p.getId() > 0)
			return personService.getById(p.getId());
		else 
			return null;
		
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId())
			//	.toUri();
		//return ResponseEntity.created(uri).build();	
	}
	
	@PutMapping("/person/{id}")
	public ResponseEntity<Object> updatePerson(@RequestBody Person p, @PathVariable int id) {
		Person pOptional = personService.getById(id);
		if (pOptional == null)
			return ResponseEntity.notFound().build();

		pOptional.setId(id);				
		personService.update(p,pOptional);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/person/{id}")
	public void deletePersonById(@PathVariable int id) {
		personService.delete(id);
	}
}
