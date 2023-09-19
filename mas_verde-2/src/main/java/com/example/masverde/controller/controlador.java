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

import com.example.masverde.interfacesService.IProveedorService;
import com.example.masverde.modelo.Proveedor;


@Controller
@RequestMapping
public class controlador {
	
	@Autowired
	private IProveedorService service;
	
	@GetMapping("/crud/listar")
	public String listar(Model model) {
		
		List<Proveedor>proveedors=service.listar();
		model.addAttribute("proveedors", proveedors);
		return "crud/index";
	}
	
	@GetMapping("/proveedores/new")
	public String agregar(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		return "crud/form";
	}
	
	@PostMapping("/saveProveedor")
	public String save(@Validated Proveedor p, Model model) {
		service.save(p);
		return "redirect:/crud/listar";
	}
	
	@GetMapping("/proveedores/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
	    Optional<Proveedor> optionalProveedor = service.listarid(id);
	    if (optionalProveedor.isPresent()) {
	    	Proveedor proveedor = optionalProveedor.get();
	        model.addAttribute("proveedor", proveedor);
	        return "crud/form";
	    } else {
	        
	        return "redirect:/crud/listar"; 
	    }
	}
	
	@GetMapping("/proveedores/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
	    service.delete(id);
	    return "redirect:/crud/listar"; 
	}
	

}
