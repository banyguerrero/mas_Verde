package com.example.masverde.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.masverde.interfacesService.IUsuariosService;
import com.example.masverde.modelo.Usuarios;


@Controller
@RequestMapping
public class UserControlador {
	
	@Autowired
	private IUsuariosService service;
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		
		List<Usuarios>users=service.listar();
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Usuarios>users=service.listar();
		model.addAttribute("users", users);
		return "/usuarios/usuarios";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("users", new Usuarios());
		return "index";
	}
	
	@PostMapping("/Usuariosave")
	public String save(@Validated Usuarios u, Model model) {
		service.save(u);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
	    Optional<Usuarios> optionalPersona = service.listarid(id);
	    if (optionalPersona.isPresent()) {
	    	Usuarios persona = optionalPersona.get();
	        model.addAttribute("persona", persona);
	        return "index";
	    } else {
	        
	        return "redirect:/listar"; // Redirige a la lista si no se encuentra la persona.
	    }
	}

	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
	    service.delete(id);
	    return "redirect:/listar"; 
	}

	
	
	

}
