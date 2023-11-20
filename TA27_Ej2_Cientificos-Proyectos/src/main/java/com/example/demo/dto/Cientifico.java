package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cientificos")
public class Cientifico {

	@Id
	@Column(name = "dni")
	private String id;
	@Column(name = "nom_apels")
	private String nombre;
	
	@ManyToMany(mappedBy = "cientificos")
	@JsonIgnore
	private List<Proyecto> proyectos;


	public Cientifico() {

	}

	public Cientifico(String id, String nombre, List<Proyecto> proyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyectos = proyectos;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	@Override
	public String toString() {
		return "Cientifico [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
