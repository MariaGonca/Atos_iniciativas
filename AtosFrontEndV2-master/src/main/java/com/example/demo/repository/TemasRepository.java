package com.example.demo.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Temas;




@Repository
public interface TemasRepository extends JpaRepository<Temas, Long> {

	List<Temas> findByTituloContaining(String titulo);
	List<Temas> findByDescripcionContaining(String descripcion);
	List<Temas> findByFechaInicioContaining(LocalDate fechaInicio);
	List<Temas> findByFechaFinContaining(LocalDate fechaFin);
	//List<Temas> findByIniciativaContaining(String iniciativa);

}
