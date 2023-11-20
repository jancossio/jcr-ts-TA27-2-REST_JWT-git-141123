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

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
		
	@GetMapping("/all")
	public List<Proyecto> listarProyectos(){
		return proyectoServiceImpl.listarProyectos();
	}
		
	@PostMapping("/add")
	public Proyecto salvarCientifico(@RequestBody Proyecto proyecto) {
			
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
		
	@GetMapping("/{id}")
	public Proyecto cientificoXID(@PathVariable(name="id") String id) {
			
		Proyecto proyecto_xid= new Proyecto();
			
		proyecto_xid = proyectoServiceImpl.proyectoXID(id);
						
		return proyecto_xid;
	}
		
	@PutMapping("/{id}")
	public Proyecto actualizarCurso(@PathVariable(name="id")String id,@RequestBody Proyecto proyecto) {
			
		Proyecto cientifico_seleccionado= new Proyecto();
		Proyecto cientifico_actualizado= new Proyecto();
			
		cientifico_seleccionado= proyectoServiceImpl.proyectoXID(id);
			
		cientifico_seleccionado.setNombre(proyecto.getNombre());
		cientifico_seleccionado.setHoras(proyecto.getHoras());

			
		cientifico_actualizado = proyectoServiceImpl.actualizarProyecto(cientifico_seleccionado);
						
		return cientifico_actualizado;
	}
		
	@DeleteMapping("/{id}")
	public void eleiminarCurso(@PathVariable(name="id")String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}
}
