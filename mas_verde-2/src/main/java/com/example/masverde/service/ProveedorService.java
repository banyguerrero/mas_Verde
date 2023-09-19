package com.example.masverde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masverde.interfaces.IProveedor;
import com.example.masverde.interfacesService.IProveedorService;
import com.example.masverde.modelo.Proveedor;

@Service
public class ProveedorService implements IProveedorService{
	
	@Autowired
	private IProveedor data;
	
	@Override
	public List<Proveedor> listar() {
		return (List<Proveedor>)data.findAll();
	}

	@Override
	public Optional<Proveedor> listarid(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Proveedor p) {
		int res=0;
		Proveedor proveedor=data.save(p);
		if (!proveedor.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
