package com.Concesionario.demo.Controladores;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Concesionario.demo.Repository.CorreoRepository;
import com.Concesionario.demo.Servicios.CorreoSreviceAPI;

import com.Concesionario.demo.entities.Correo;


@Controller
public class Correocontroller {

	@Autowired
	private CorreoRepository correoRepository;
	@Autowired
	private CorreoSreviceAPI correoServiceAPI;
	
	
	@GetMapping("/correo/new")
	public String newCorreo(Model model) {
		model.addAttribute("correo", new Correo());
		return "correo";
		
	}
	
	@PostMapping("/correos")
	public String saveCorreo(@ModelAttribute("correo") Correo correo) {
		System.out.println(correo);
		correoRepository.save(correo);
		return "contestacion_Correo";
	}
	
	
	
	@GetMapping("/correo1/new")
	public String newCorreo1(Model model) {
		model.addAttribute("correo", new Correo());
		return "correo1";
		
	}
	
	@PostMapping("/correos1")
	public String saveCorreo1(@ModelAttribute("correo") Correo correo) {
		System.out.println(correo);
		correoRepository.save(correo);
		return "Pagina5";
	}
	
	
	
	
	
	@GetMapping("/correos/{id}/delete")
	public String deleteCorreo(@PathVariable Long id){

		correoRepository.deleteById(id);
		return "redirect:/correopaginada";

	}
	
	
	
	
	@GetMapping("/correos/delete")
	public String deleteCars() {
		correoRepository.deleteAll();
		return "redirect:/correopaginada";
	}
	

	
	

	
	@GetMapping(value = "/correopaginada")
	public String finnAll (@RequestParam Map <String, Object> params, Model model){
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 2);
		Page<Correo> pageCorreos = correoServiceAPI.gettAll(pageRequest);
		
		int totalPage =  pageCorreos.getTotalPages();
		if (totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());		
			model.addAttribute("pages", pages);		
		}
		model.addAttribute("list", pageCorreos.getContent());

		return "correopaginada";
	}
	
	
}