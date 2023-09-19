package com.example.masverde.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.masverde.modelo.Usuarios;


public interface IUsuariosService {
	public List<Usuarios>listar();
	public Optional<Usuarios>listarid(int id);
	public int save(Usuarios u);
	public void delete(int id);
}
