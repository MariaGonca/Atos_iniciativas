package com.demo.payload.service;

import java.util.List;

import com.example.demo.model.Iniciativa;

public interface IIniciativaService {

public List<Iniciativa> findAll();
	
	public Iniciativa findById(Long id);
	
	public Iniciativa save(Iniciativa foto);
	
	public void delete(Long id);
	
	List<Iniciativa> findActiva();
	
	List<Iniciativa> findInactiva();
	
	
	
	List<Iniciativa> findTitulo(String titulo);
	
	List<Iniciativa> findDescripcion(String descripcion);

	List<Iniciativa> findInicio(String inicio);

	List<Iniciativa> findFin(String descripcion);
	
	
	
	List<Iniciativa> findByTituloAndDescripcion(String titulo, String descripcion);

	List<Iniciativa> findByTituloAndDescripcionAndInicioAndFin(String titulo, String descripcion, String inicio, String fin);
		
	List<Iniciativa> findByTituloAndDescripcionAndInicioAndFinAndActiva(String titulo, String descripcion, String inicio, String fin, Boolean activa);
	
}
