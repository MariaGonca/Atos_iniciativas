package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Iniciativa;

// TODO: Auto-generated Javadoc
/**
 * The Interface IIniciativaService.
 */
public interface IIniciativaService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Iniciativa> findAll();
		
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the iniciativa
	 */
	public Iniciativa findById(Long id);
	
	/**
	 * Save.
	 *
	 * @param iniciativa the iniciativa
	 * @return the iniciativa
	 */
	public Iniciativa save(Iniciativa iniciativa);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(Long id);
	
	/**
	 * Find activa.
	 *
	 * @return the list
	 */
	List<Iniciativa> findActiva();
	
	/**
	 * Find inactiva.
	 *
	 * @return the list
	 */
	List<Iniciativa> findInactiva();
	
	
	/**
	 * Find titulo iniciativa.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @return the list
	 */
	List<Iniciativa> findTituloIniciativa(String tituloIniciativa);
	
	/**
	 * Find descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	List<Iniciativa> findDescripcion(String descripcion);
	
	/**
	 * Find inicio.
	 *
	 * @param inicio the inicio
	 * @return the list
	 */
	List<Iniciativa> findInicio(String inicio);
	
	/**
	 * Find fin.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	List<Iniciativa> findFin(String descripcion);
	
	
	/**
	 * Find by titulo iniciativa and descripcion.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @return the list
	 */
	List<Iniciativa> findByTituloIniciativaAndDescripcion(String tituloIniciativa, String descripcion);
	
	
	/**
	 * Find by titulo iniciativa and descripcion and inicio and fin.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the list
	 */
	List<Iniciativa> findByTituloIniciativaAndDescripcionAndInicioAndFin(@Param("tituloIniciativa") String tituloIniciativa, @Param("descripcion") String descripcion, @Param("inicio") String inicio, @Param("fin") String fin);
	
	/**
	 * Find by titulo iniciativa and descripcion and inicio and fin and activa.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param activa the activa
	 * @return the list
	 */
	@Query("SELECT i FROM Iniciativa i WHERE (:tituloIniciativa is null or i.tituloIniciativa LIKE %:tituloIniciativa%) and (:descripcion is null or i.descripcion LIKE %:descripcion%) and (:inicio is null or i.inicio LIKE %:inicio%) and (:fin is null or i.fin LIKE %:fin%) and (:activa is null or i.activa = :activa)")
	List<Iniciativa> findByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(@Param("tituloIniciativa") String tituloIniciativa, @Param("descripcion") String descripcion, @Param("inicio") String inicio, @Param("fin") String fin, @Param("activa") Boolean activa);

}