package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entities.LoginData;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model) {
		
		System.out.println("Opening form..");
		model.addAttribute("loginData",new LoginData());
		return "form";
	}
	
	/* Handler for process form */
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("bindingResult"+bindingResult);
			return "form";
		}
		
		System.out.println("loginData :: "+loginData);
		return "success";
	}
	
}
