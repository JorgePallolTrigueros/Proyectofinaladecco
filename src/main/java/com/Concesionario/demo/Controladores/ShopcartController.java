package com.Concesionario.demo.Controladores;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Concesionario.demo.Repository.CarRepository;
import com.Concesionario.demo.entities.Car;
import com.Concesionario.demo.entities.Shopcart;
import com.Concesionario.demo.entities.User;
import com.Concesionario.demo.Repository.ShopcartRepository;
import com.Concesionario.demo.Repository.UserRepository;



@Controller
public class ShopcartController {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ShopcartRepository shopcartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// ADD MOVIE TO CURRENT SHOPCART IN SESSION
	@GetMapping("/shopcarts/{id}/addcar")
	public String addToShopCart(@PathVariable Long id, Model model, HttpSession session) {
		// Check if there is shopcart in current session
		Shopcart shopcart = (Shopcart) session.getAttribute("shopcart");
		if (shopcart == null) {
			// is is null it means it's the first time that user click on add car
			shopcart = new Shopcart();
		}
		
		//  Find car in database
		Optional<Car> carOpt = carRepository.findById(id);
		if (carOpt.isPresent()) { // If car exists then add it to shopcart
			Car car = carOpt.get();
			// If shopcart doesn't contains car then add it
			if (!shopcart.getCars().contains(car)) {
				shopcart.getCars().add(car);
			}
		}
		// save shopcart in session
		session.setAttribute("shopcart", shopcart);
		// save in model number of cars in shopcart
		model.addAttribute("shopcart_items", shopcart.getCars().size());
		model.addAttribute("cars", carRepository.findAll());
		return "car-list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// DELETE MOVIE FROM CURRENT SHOPCART IN SESSION CAR
	@GetMapping("/shopcarts/{id}/deletecar")
	public String deleteToShopCart(@PathVariable Long id, Model model, HttpSession session) {
		// Check if there is shopcart in current session
		Shopcart shopcart = (Shopcart) session.getAttribute("shopcart");
		if (shopcart == null) 
			return "redirect:/cars";

		//  Find car in database
		Optional<Car> carOpt = carRepository.findById(id);
		if (carOpt.isPresent()) { // If car exists then add it to shopcart
			Car car = carOpt.get();
			// If shopcart doesn't contains car then add it
			if (shopcart.getCars().contains(car)) {
				shopcart.getCars().remove(car);
			}
		}
		// save shopcart in session
		session.setAttribute("shopcart", shopcart);
		// save in model number of cars in shopcart
		model.addAttribute("totalPrice", calculateTotalPrice(shopcart));
		model.addAttribute("shopcart_items", shopcart.getCars().size());
		model.addAttribute("shopcart", shopcart);
		model.addAttribute("cars", carRepository.findAll());
		return "shopcart";
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	// SEE CURRENT SHOPCART IN SESSION CAR
	@GetMapping("/shopcart")
	public String seeShopcart(Model model, HttpSession session) {
		// Check if there is shopcart in current session
		Shopcart shopcart = (Shopcart) session.getAttribute("shopcart");
		if (shopcart == null) {
			// is is null it means it's the first time that user click on add car
			shopcart = new Shopcart();
		}
		model.addAttribute("totalPrice", calculateTotalPrice(shopcart));
		model.addAttribute("shopcart_items", shopcart.getCars().size());
		model.addAttribute("shopcart", shopcart);
		return "shopcart";
	}
	private double calculateTotalPrice(Shopcart shopcart) {
		if (shopcart == null || shopcart.getCars() == null) {
			return 0;
		}
		double totalPrice = 0;
		for (Car car : shopcart.getCars()) {
			if (car.getPrice() != null)	
				totalPrice += car.getPrice();
		}
		return totalPrice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// FINALIZE BUY 
	@GetMapping("/shopcarts/checkout")
	public String checkout(Model model, HttpSession session) {
		// Get user and shopcart from session
		Shopcart shopcart = (Shopcart) session.getAttribute("shopcart");
		User user = (User) session.getAttribute("user");
		
		// if thereisnt user or session go out to cars list
		if (shopcart == null || user == null) 
			return "redirect:/cars";
		
		// retrieve user from DB
		Optional<User> userDBOpt = userRepository.findById(user.getId());
		if (!userDBOpt.isPresent()) // IF user doesnt exist then go out to cars list
			return "redirect:/cars";
		
		// set user in shopcart
		shopcart.setUser(userDBOpt.get());
		// save shopcart in DB
		shopcartRepository.save(shopcart);
		// remove shopcart from session
		session.removeAttribute("shopcart");
		return "shopcart-checkout";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//*********** show the all listshops 
		@GetMapping("/shopcarts/list")
		public String showallshopcart(Model model, HttpSession session) {
			// Get user and shopcart from session
			User user = (User) session.getAttribute("user");
			model.addAttribute("user", user);
				//retrieve all shopcarts in user session
			model.addAttribute("usercart",shopcartRepository.findAllByUserId(user.getId()));
			return "shopcart-list";
		}
		
	
	
	
}