package com.tonyb650.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tonyb650.dojosninjas.models.Dojo;
import com.tonyb650.dojosninjas.models.Ninja;
import com.tonyb650.dojosninjas.services.DojoService;
import com.tonyb650.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;

	// Why is below different than @Autowired ??
//	private DojoService dojoService;
//	private NinjaService ninjaService;
//	
//	public DojoController(DojoService dojoService, NinjaService ninjaService) {
//		this.dojoService = dojoService;
//		this.ninjaService = ninjaService;
//	}
	
	@GetMapping("/dojos/new")
	public String addDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String addDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo  = dojoService.getDojoById(id);
		model.addAttribute("dojo", dojo);
		return "dojoroster.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String addNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "newninja.jsp";
		}
		ninjaService.create(ninja);
		return "redirect:/dojos/new";
	}
	
	@PostMapping("/dojo/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/dojos/new";
	}
}
