package upc.edu.pe.webdevs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import upc.edu.pe.webdevs.model.Artist;
import upc.edu.pe.webdevs.service.IArtistService;

@Controller
@RequestMapping("/artists")
public class ArtistController {

	@Autowired
	private IArtistService artistService;
	
	@GetMapping("/list")
	public String listArtist(Model model) {
		
		try {
			model.addAttribute("listArtist", artistService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/artist/list";
	}
	
	@GetMapping("/add")
	public String addArtist(Model model) {
		
		
		return "/artist/add";
	}
	
	@PostMapping("/add")
	public String addArtist(Model model, String firstName, String lastName, Long dni, String email,Long phone, String skill, String genre, String websiteUrl) {
		
			
			Artist ar1=new Artist();
			ar1.setFirstName(firstName);
			ar1.setLastName(lastName);
			ar1.setDni(dni);
			ar1.setEmail(email);
			ar1.setPhone(phone);
			ar1.setSkill(skill);
			ar1.setGenre(genre);
			ar1.setWebsiteUrl(websiteUrl);
			
			
			try {
				model.addAttribute("registerArtist", artistService.save(ar1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return "/artist/add";
	}
	
	@GetMapping("/detail/{id}")
	public String detailArtist(@PathVariable(value="id") Integer id,Model model ) {
		try {
			Optional<Artist> artist = artistService.findById(id);
			
			if(!artist.isPresent()) {
				model.addAttribute("info", "Artist doesn't exist");
				return "redirect:/artist/list";
			}
			else
				model.addAttribute("artist",artist.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/artist/detail";
	}
}
