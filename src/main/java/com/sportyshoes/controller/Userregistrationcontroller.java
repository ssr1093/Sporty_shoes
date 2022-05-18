package com.sportyshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportyshoes.dto.Registrationdto;
import com.sportyshoes.service.Userservice;

@Controller
@RequestMapping("/registration")
public class Userregistrationcontroller {
	private Userservice userService;

	public Userregistrationcontroller(Userservice userService) {
		super();
		this.userService = userService;
	}
	 @ModelAttribute("user")
	    public Registrationdto userRegistrationDto() {
	        return new Registrationdto();
	    }
	 @GetMapping
	    public String showRegistrationForm() {
	        return "registration";
	    }
	@PostMapping
    public String registerUserAccount(@ModelAttribute("user") Registrationdto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/login?registrationsuccess";
    }
}
