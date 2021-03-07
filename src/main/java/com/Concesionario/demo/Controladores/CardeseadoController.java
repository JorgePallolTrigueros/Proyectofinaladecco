package com.Concesionario.demo.Controladores;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Concesionario.demo.entities.Cardeseado;
import com.Concesionario.demo.Repository.AcabadosRepository;
import com.Concesionario.demo.Repository.CardeseadoRepository;
import com.Concesionario.demo.Repository.ColorRepository;
import com.Concesionario.demo.Repository.MotorRepository;
import com.Concesionario.demo.Servicios.CardeseadoSreviceAPI;



@Controller
public class CardeseadoController {







	@Autowired
	private CardeseadoRepository cardeseadoRepository;
	

	@Autowired
	private MotorRepository motorRepository;
	

	@Autowired
	private ColorRepository colorRepository;
	

	@Autowired
	private AcabadosRepository acabadoRepository;
	
	@Autowired
	private CardeseadoSreviceAPI cardeseadoServiceAPI;

	

	//Debe ser nuevo

	
	
	@GetMapping("/cochedeseado/new")
	public String newMovie(Model model) {
		model.addAttribute("carsdeseados", new Cardeseado());
		model.addAttribute("color", colorRepository.findAll());
		model.addAttribute("motor", motorRepository.findAll());
		model.addAttribute("acabado", acabadoRepository.findAll());
		return "pagina3";
		
	}

	


	
	
	
	
	
	
	
	
	
	@PostMapping(value = "/Cardeseadocreado")
	public  String  Cardeseado (@ModelAttribute Cardeseado cardeseado, HttpSession session, Model model){
		
		double finalPrice = 15000;

		
		// Primer Select
				if (cardeseado.getMotor().getDescripcion()=="1.4") {
					finalPrice +=500;
				}
				if (cardeseado.getMotor().getDescripcion()=="1.5") {
					finalPrice +=900;
				}
				if (cardeseado.getMotor().getDescripcion()=="1.8") {
					finalPrice +=1500;
				}
		
		// Segundo Select
				if (cardeseado.getColor().getDescripcion()=="azul") {
					finalPrice +=500;	
				}
				else if (cardeseado.getColor().getDescripcion()=="blanco") {
					finalPrice +=900;
				}
				else if(cardeseado.getColor().getDescripcion()=="rojo") {
					finalPrice +=1500;
				}
			 
		
		// Tercero Select
				if (cardeseado.getAcabado().getDescripcion()=="acabados1") {
					finalPrice +=500;
				}
				else if (cardeseado.getAcabado().getDescripcion()=="acabados2") {
					finalPrice +=900;
				}
				else if(cardeseado.getAcabado().getDescripcion()=="acabados3") {
					finalPrice +=1500;
				}
		
		//Hacer el to string para mandarlo con 
			
				String resultado ="El coche que nos has pedido tiene las siguientes prestaciones marca \"+cochedesado.getcolor()+\" "
							+ "color \"+form-select2+\" acabado:\"+form-select3+\" y el coste es:\"+finalPrice+\"   ";
			
				model.addAttribute("resultado", resultado);
				model.addAttribute("finalPrice", finalPrice);
				//Carddesado.setPrice(finalPrice)
				//Car
				//Save y grabar carddesado.save
		return "resultado";
	
		
	}
	
	

	
	@GetMapping(value = "/cardesadopaginada")
	public String finnAll (@RequestParam Map <String, Object> params, Model model){
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 2);
		Page<Cardeseado> pageCardeseados = cardeseadoServiceAPI.gettAll(pageRequest);
		
		int totalPage =  pageCardeseados.getTotalPages();
		if (totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());		
			model.addAttribute("pages", pages);		
		}
		model.addAttribute("list", pageCardeseados.getContent());

		return "cardesadopaginada";
	}
	



	
	
	
	// TODO - recuperar uno, crear, editar, borrar
	
}
