package com.example.masverde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masverde.interfaces.IUsuarios;
import com.example.masverde.interfacesService.IUsuariosService;
import com.example.masverde.modelo.Usuarios;



@Service
public class UsuariosService implements IUsuariosService{
	
	@Autowired
	private IUsuarios data;
	
	@Override
	public List<Usuarios> listar() {
		return (List<Usuarios>)data.findAll();
	}

	@Override
	public Optional<Usuarios> listarid(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Usuarios u) {
		int res=0;
		Usuarios usuarios=data.save(u);
		if (!usuarios.equals(null)) {
			res=1;
		}
		return res;
	}
	
	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	

}