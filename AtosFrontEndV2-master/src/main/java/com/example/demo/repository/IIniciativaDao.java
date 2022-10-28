package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Iniciativa;


public interface IIniciativaDao extends JpaRepository<Iniciativa, Long>{
	public List<Iniciativa> findByActivaTrue();
	
	public List<Iniciativa> findByActivaFalse();
	
	public List<Iniciativa> findByTitulo(String titulo);
	
	public List<Iniciativa> findByDescripcion(String descripcion);
	
	public List<Iniciativa> findByInicio(String inicio);

	public List<Iniciativa> findByFin(String fin);
	
	

	
	public List<Iniciativa> findByTituloAndDescripcionAndInicioAndFin(String titulo, String descripcion, String inicio, String fin);
	
	public List<Iniciativa> findByTituloAndDescripcionAndInicioAndFinAndActiva(String titulo, String descripcion, String inicio, String fin, Boolean activa);
	
	public List<Iniciativa> findByTituloAndDescripcion(String titulo, String descripcion);
}
