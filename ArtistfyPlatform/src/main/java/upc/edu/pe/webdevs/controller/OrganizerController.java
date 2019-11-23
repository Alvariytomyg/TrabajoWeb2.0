package upc.edu.pe.webdevs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import upc.edu.pe.webdevs.model.Organizer;
import upc.edu.pe.webdevs.service.IOrganizerService;

@Controller
@RequestMapping("/organizers")
public class OrganizerController {

	@Autowired
	private IOrganizerService organizerService;
	
	@GetMapping("/list")
	public String listOrganizer(Model model) {
		
		try {
			model.addAttribute("listOrganizer", organizerService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/organizer/list";
	}
	
	@GetMapping("/add")
	public String addOrganizer(Model model) {
		
		
		return "/organizer/add";
	}
	
	@PostMapping("/add")
	public String addOrganizer(Model model,String firstName, String lastName, Long dni, String email,Long phone) {
		
			
			Organizer or1=new Organizer();
			or1.setFirstName(firstName);
			or1.setLastName(lastName);
			or1.setDni(dni);
			or1.setEmail(email);
			or1.setPhone(phone);
			
			
			
			try {
				model.addAttribute("registerOrganizer", organizerService.save(or1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return "/organizer/add";
	}
	
	@GetMapping("/detail/{id}")
	public String detailOrganzier(@PathVariable(value="id") Integer id,Model model ) {
		try {
			Optional<Organizer> organizer = organizerService.findById(id);
			
			if(!organizer.isPresent()) {
				model.addAttribute("info", "Organizer doesn't exist");
				return "redirect:/organizer/list";
			}
			else
				model.addAttribute("organizer",organizer.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/organizer/detail";
	}
}
