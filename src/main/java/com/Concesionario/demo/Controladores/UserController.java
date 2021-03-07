package com.Concesionario.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.Concesionario.demo.Repository.UserRepository;
import com.Concesionario.demo.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/user/new")
	public String newCar(Model model) {
		model.addAttribute("user", new User());
		return "pagina2";
		
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/login";
	}
	
}
