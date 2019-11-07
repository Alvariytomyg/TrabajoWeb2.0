package pe.edu.upc.webdevs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.webdevs.model.Person;
import pe.edu.upc.webdevs.service.IPersonService;


@Controller
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	@GetMapping("/list")
	public String listarPerson(Model model) {
		
		try {
			model.addAttribute("listPerson", personService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/person/list";
	}
	
	@GetMapping("/add")
	public String agregarPerson(Model model) {
		
		
		return "/person/add";
	}
	
	@PostMapping("/add")
	public String agregarPerson(Model model,String firstName,String lastName,Long dni,String email,Long phone) {
		
		Person pe1=new Person();
		pe1.setFirstName(firstName);
		pe1.setLastName(lastName);
		pe1.setDni(dni);
		pe1.setEmail(email);
		pe1.setPhone(phone);

		
		try {
			model.addAttribute("registerPerson", personService.save(pe1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/person/add";
	}
	
	@GetMapping("/detail/{id}")
	public String detailPerson(@PathVariable(value="id") Integer id,Model model ) {
		try {
			Optional<Person> person = personService.findById(id);
			
			if(!person.isPresent()) {
				model.addAttribute("info", "Person doesn't exist");
				return "redirect:/person/list";
			}
			else
				model.addAttribute("person",person.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/person/detail";
	}
}
