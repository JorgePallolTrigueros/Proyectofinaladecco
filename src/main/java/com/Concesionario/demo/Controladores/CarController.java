package com.Concesionario.demo.Controladores;


import java.util.Map;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.Concesionario.demo.entities.Car;
import com.Concesionario.demo.Repository.CarRepository;
import com.Concesionario.demo.Repository.EtiquetaRepository;
import com.Concesionario.demo.Repository.ManufacturerRepository;
import com.Concesionario.demo.Servicios.CarSrviceAPI;
import com.Concesionario.demo.entities.User;


@Controller
public class CarController {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
	private CarSrviceAPI carServiceAPI;
	
	@GetMapping({"/cars", "/"})
	public String findCars(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user != null)
			model.addAttribute("user", user);
		model.addAttribute("cars", carRepository.findAll());
		return "car-list";
	}
	
	@GetMapping("/usercars")
	public String findUserCars(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			return "redirect:/login";
		model.addAttribute("user", user);
		model.addAttribute("cars", carRepository.findAllByUsersId(user.getId()));
		return "car-list";
	}
	
	@GetMapping("/cars/{id}/view")
	public String viewCar(@PathVariable Long id, Model model) {
		Optional<Car> carOpt = carRepository.findById(id);
		if (!carOpt.isPresent()) {
			model.addAttribute("error", "ID car not found.");
			model.addAttribute("cars", carRepository.findAll());
			return "car-list";
		}
		model.addAttribute("car", carOpt.get());
		return "car-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/cars/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("manufacturer", manufacturerRepository.findAll());
		model.addAttribute("etiquetasDBList", etiquetaRepository.findAll());
		return "car-edit";
		
	}
	
	@GetMapping("/cars/{id}/edit")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carRepository.findById(id).get());
		model.addAttribute("manufacturer", manufacturerRepository.findAll());
		model.addAttribute("etiquetasDBList", etiquetaRepository.findAll());
		return "car-edit";
		
	}
	
	@PostMapping("/cars")
	public String saveCar(@ModelAttribute("car") Car car) {
		System.out.println(car);
		carRepository.save(car);
		// Si queremos operar con el FilmProducer asociado a esta car lo podemos obtener con getter:
		// car.getFilmProducer().getYear()
		return "redirect:/cars";
	}
	
	@GetMapping("/cars/{id}/delete")
	public String deleteCar(@PathVariable Long id){

		carRepository.deleteById(id);
		return "redirect:/cars";

	}
	
	
	
	
	@GetMapping("/cars/delete")
	public String deleteCars() {
		carRepository.deleteAll();
		return "redirect:/cars";
	}
	
	@GetMapping("/cars/{code}/search")
	public String searchCarByCode(@PathVariable Integer code, Model model) {
		model.addAttribute("cars", carRepository.findAllByCode(code));
		return "carpaginada";
		
	}
	
	

	
	@GetMapping(value = "/carpaginada")
	public String finnAll (@RequestParam Map <String, Object> params, Model model){
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 2);
		Page<Car> pageCars = carServiceAPI.gettAll(pageRequest);
		
		int totalPage =  pageCars.getTotalPages();
		if (totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());		
			model.addAttribute("pages", pages);		
		}
		model.addAttribute("list", pageCars.getContent());

		return "carpaginada";
	}
	
	
}