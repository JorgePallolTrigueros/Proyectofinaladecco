package com.Concesionario.demo.Controladores;



import javax.servlet.http.HttpSession;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class OtrosController {

	@GetMapping({"/pagina1"})
	public String pagina1(Model model, HttpSession session) {

		return "pagina1";
	}
	
	@GetMapping({"/resultado"})
	public String resultado(Model model, HttpSession session) {

		return "resultado";
	}
	
	
	@GetMapping({"/pagina2"})
	public String pagina2(Model model, HttpSession session) {

		return "pagina2";
	}
	

	
	@GetMapping({"/correo"})
	public String correo(Model model, HttpSession session) {

		return "correo";
	}
	

	@GetMapping({"/pagina6"})
	public String pagina6(Model model, HttpSession session) {

		return "pagina6";
	}
	

	
	@GetMapping({"/correo1"})
	public String correo1(Model model, HttpSession session) {

		return "correo1";
	}



}
