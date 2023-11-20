package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoService {

	public List<Cientifico> listarCientificos(); 
	
	public Cientifico guardarCientifico(Cientifico cientifico);	
	
	public Cientifico cientificoXID(String id); 
	
	public Cientifico actualizarCientifico(Cientifico cientifico); 
	
	public void eliminarCientifico(String id);
}
