package com.example.masverde.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.masverde.modelo.Proveedor;


public interface IProveedorService {
	public List<Proveedor>listar();
	public Optional<Proveedor>listarid(int id);
	public int save(Proveedor p);
	public void delete(int id);

}
