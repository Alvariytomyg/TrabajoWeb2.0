package upc.edu.pe.webdevs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import upc.edu.pe.webdevs.model.Person;
import upc.edu.pe.webdevs.model.SubscriptionPlan;
import upc.edu.pe.webdevs.service.ISubscriptionPlanService;

public class SubscriptionPlanController {

	@Autowired
	private ISubscriptionPlanService subscriptionPlanService;
	
	@GetMapping("/list")
	public String listarSubscriptionPlan (Model model) {
	
		try {
			model.addAttribute("listSubscriptionPlan", subscriptionPlanService.findAll());
		} catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/subscriptionPlan/list";
		
	}
	
	@GetMapping("/add")
	public String agregarSubscriptionPlan(Model model) {
		return "/subscriptionPlan/add";
	}
	
	@PostMapping("/add")
	public String agregarSubscriptionPlan(Model model,String name,String description,Double price) {
		
		SubscriptionPlan Subp1=new SubscriptionPlan();
		Subp1.setName(name);
		Subp1.setDescription(description);
		Subp1.setPrice(price);

		try {
			model.addAttribute("registerSubscriptionPlan", subscriptionPlanService.save(Subp1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/subscriptionPlan/add";
	}
	
	@GetMapping("/detail/{id}")
	public String detailSubscriptionPlan(@PathVariable(value="id") Integer id,Model model ) {
		try {
			Optional<SubscriptionPlan> subscriptionPlan = subscriptionPlanService.findById(id);
			
			if(!subscriptionPlan.isPresent()) {
				model.addAttribute("info", "subscriptionPlan doesn't exist");
				return "redirect:/subscriptionPlan/list";
			}
			else
				model.addAttribute("subscriptionPlan",subscriptionPlan.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/subscriptionPlan/detail";
	}
	
	
}
