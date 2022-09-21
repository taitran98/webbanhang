package com.example.webbanhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class banhangcontroller {

	@Autowired
	private webbanhangDAO dao;

	@RequestMapping("/")
	public String index() {
		return "index";

	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/confirm")
	public String confirm() {
		return "confirm";
	}

	@GetMapping("/registerUser")
	public String NewForm(Model model) {
		Register register = new Register();

		model.addAttribute("register", register);
		return "newUser";

	}
	@PostMapping("/registerUser")
	public String submitform(@Validated @ModelAttribute("register") Register register, BindingResult bindingResult,
			Model model) {
		model.addAttribute("register", register);
		if (bindingResult.hasErrors()) {
			return "newUser";
			
		} else {
			dao.register(register);
			return "confirm";
		}
	}	

}
