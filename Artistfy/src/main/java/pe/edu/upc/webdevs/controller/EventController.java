package pe.edu.upc.webdevs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.webdevs.model.Event;
import pe.edu.upc.webdevs.service.IEventService;

@Controller
@RequestMapping("/events")
public class EventController {

	@Autowired
	private IEventService eventService;
	
	@GetMapping("/list")
	public String listarEvent(Model model) {
		
		try {
			model.addAttribute("listEvent", eventService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/event/list";
	}
	
	@GetMapping("/add")
	public String agregarEvent(Model model) {
		
		
		return "/event/add";
	}
	
	@PostMapping("/add")
	public String agregarEvent(Model model,String name,String description,String requeriments,Double offeredSalary,String scheduleAt) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date=formato.parse(scheduleAt);
			
			Event ev1=new Event();
			ev1.setName(name);
			ev1.setDescription(description);
			ev1.setRequeriments(requeriments);
			ev1.setOfferedSalary(offeredSalary);
			ev1.setScheduleAt(date);
			
			
			try {
				model.addAttribute("registerEvent", eventService.save(ev1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "/event/add";
	}
	
	@GetMapping("/detail/{id}")
	public String detailEvent(@PathVariable(value="id") Integer id,Model model ) {
		try {
			Optional<Event> event = eventService.findById(id);
			
			if(!event.isPresent()) {
				model.addAttribute("info", "Event doesn't exist");
				return "redirect:/event/list";
			}
			else
				model.addAttribute("event",event.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/event/detail";
	}
}