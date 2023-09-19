package com.example.masverde.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.masverde.modelo.Usuarios;

public interface IUsuarios extends CrudRepository <Usuarios, Integer>{
	
}