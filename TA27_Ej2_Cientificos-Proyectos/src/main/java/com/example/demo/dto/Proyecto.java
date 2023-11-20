package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name="proyectos")
public class Proyecto {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "horas")
	private Integer horas;
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "asignado_a",
        joinColumns = @JoinColumn(name = "proyecto_id"),
        inverseJoinColumns = @JoinColumn(name = "cientifico_dni")
    )
	
	@JsonIgnoreProperties("proyectos")
    private List<Cientifico> cientificos;
    

	public Proyecto() {

	}

	public Proyecto(String id, String nombre, Integer horas, List<Cientifico> cientificos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.cientificos = cientificos;
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

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public List<Cientifico> getCientificos() {
		return cientificos;
	}

	public void setCientificos(List<Cientifico> cientificos) {
		this.cientificos = cientificos;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", asignados=" + "]";
	}
	
	
}
