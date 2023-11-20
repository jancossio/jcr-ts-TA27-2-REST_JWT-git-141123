package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/cientifico")
public class CientificoController {
		
	@Autowired
	CientificoServiceImpl cientificoServideImpl;
		
	@GetMapping("/all")
	public List<Cientifico> listarCientificos(){
		return cientificoServideImpl.listarCientificos();
	}
		
	@PostMapping("/add")
	public Cientifico salvarCientifico(@RequestBody Cientifico cientifico) {
			
		return cientificoServideImpl.guardarCientifico(cientifico);
	}
		
	@GetMapping("/{id}")
	public Cientifico cientificoXID(@PathVariable(name="id") String id) {
			
		Cientifico ccientifico_xid= new Cientifico();
			
		ccientifico_xid = cientificoServideImpl.cientificoXID(id);
						
		return ccientifico_xid;
	}
		
	@PutMapping("/{id}")
	public Cientifico actualizarCurso(@PathVariable(name="id")String id,@RequestBody Cientifico cientifico) {
			
		Cientifico cientifico_seleccionado= new Cientifico();
		Cientifico cientifico_actualizado= new Cientifico();
			
		cientifico_seleccionado= cientificoServideImpl.cientificoXID(id);
			
		cientifico_seleccionado.setNombre(cientifico.getNombre());
			
		cientifico_actualizado = cientificoServideImpl.actualizarCientifico(cientifico_seleccionado);
						
		return cientifico_actualizado;
	}
		
	@DeleteMapping("/{id}")
	public void eleiminarCurso(@PathVariable(name="id")String id) {
		cientificoServideImpl.eliminarCientifico(id);
	}
}
