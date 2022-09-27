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
	public String index(Model model) {
		model.addAttribute("login", new Login());
		return "index";

	}

	@RequestMapping("/login")
	public String Login(@Validated @ModelAttribute("login") Login login, BindingResult bindingResult, Model model) {

		model.addAttribute("login", new Login());
		
		return "login";

	}

	@PostMapping("/formLogin")
	public String formLogins(@Validated  @ModelAttribute("login") Login login, BindingResult bindingResult, Model model)
	{
		model.addAttribute("login", login);
		if (bindingResult.hasErrors()) {
			return "login";
		}
		else 
		{
			return "index";
		}
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
	public String confirm(@Validated @ModelAttribute("register") Register register, BindingResult bindingResult,
			Model model) {
		model.addAttribute("register", register);

		if (bindingResult.hasErrors()) {
			return "newUser";
		} else {
			dao.register(register);
			return "confirm";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("register") Register register) {

		dao.update(register);

		return "redirect:/";
	}

}
