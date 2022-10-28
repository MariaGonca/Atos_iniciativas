package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Iniciativa;
import com.example.demo.model.Temas;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITemasService.
 */
public interface ITemasService {

/**
 * Find all.
 *
 * @return the list
 */
public List<Temas> findAll();
	
	/**
	 * Find by id tema.
	 *
	 * @param idTema the id tema
	 * @return the temas
	 */
	public Temas findByIdTema(Long idTema);
	
	/**
	 * Save.
	 *
	 * @param tema the tema
	 * @return the temas
	 */
	public Temas save(Temas tema);
	
	/**
	 * Delete.
	 *
	 * @param idTema the id tema
	 */
	public void delete(Long idTema);
	
	
	/**
	 * Find titulo.
	 *
	 * @param titulo the titulo
	 * @return the list
	 */
	List<Temas> findTitulo(String titulo);
	
	/**
	 * Find descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	List<Temas> findDescripcion(String descripcion);

	/**
	 * Find inicio.
	 *
	 * @param inicio the inicio
	 * @return the list
	 */
	List<Temas> findInicio(String inicio);

	/**
	 * Find fin.
	 *
	 * @param fin the fin
	 * @return the list
	 */
	List<Temas> findFin(String fin);
	
	/**
	 * List.
	 *
	 * @return the list
	 */
	List<Temas> list();
	
	/**
	 * Find by titulo and descripcion and inicio and fin.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the list
	 */
	@Query("SELECT i FROM Temas i WHERE (:titulo is null or i.titulo LIKE %:titulo%) and (:descripcion is null or i.descripcion LIKE %:descripcion%) and (:inicio is null or i.inicio = :inicio) and (:fin is null or i.fin = :fin)")
	public List<Temas> findByTituloAndDescripcionAndInicioAndFin(@Param("titulo") String titulo, @Param("descripcion") String descripcion,@Param("inicio") String inicio,@Param("fin") String fin);
			
	
	
	/**
	 * Find by titulo and descripcion.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @return the list
	 */
	List<Temas> findByTituloAndDescripcion(String titulo, String descripcion);

	/**
	 * Find by titulo and descripcion and inicio and fin and iniciativa.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param idIniciativa the id iniciativa
	 * @return the list
	 */
	@Query("SELECT i FROM Temas i WHERE (:titulo is null or i.titulo LIKE %:titulo%) and (:descripcion is null or i.descripcion LIKE %:descripcion%) and (:inicio is null or i.inicio LIKE %:inicio%) and (:fin is null or i.fin LIKE %:fin%) and (:idIniciativa is null or i.iniciativa IN :idIniciativa)")
	List<Temas> findByTituloAndDescripcionAndInicioAndFinAndIniciativa(@Param("titulo") String titulo, @Param("descripcion") String descripcion, @Param("inicio") String inicio, @Param("fin") String fin, @Param("idIniciativa") Iniciativa idIniciativa);
	
	/**
	 * Find by iniciativa id iniciativa.
	 *
	 * @param idIniciativa the id iniciativa
	 * @return the list
	 */
	public List<Temas> findByIniciativaIdIniciativa(Long idIniciativa);

}

