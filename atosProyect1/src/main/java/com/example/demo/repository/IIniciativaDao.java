package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Iniciativa;


// TODO: Auto-generated Javadoc
/**
 * The Interface IIniciativaDao.
 */
public interface IIniciativaDao extends JpaRepository<Iniciativa, Long>{
	
	/**
	 * Find by activa true.
	 *
	 * @return the list
	 */
	public List<Iniciativa> findByActivaTrue();
	
	/**
	 * Find by activa false.
	 *
	 * @return the list
	 */
	public List<Iniciativa> findByActivaFalse();
	
	/**
	 * Find by titulo iniciativa.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @return the list
	 */
	public List<Iniciativa> findByTituloIniciativa(String tituloIniciativa);
	
	/**
	 * Find by descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	public List<Iniciativa> findByDescripcion(String descripcion);
	
	/**
	 * Find by inicio.
	 *
	 * @param inicio the inicio
	 * @return the list
	 */
	public List<Iniciativa> findByInicio(String inicio);

	/**
	 * Find by fin.
	 *
	 * @param fin the fin
	 * @return the list
	 */
	public List<Iniciativa> findByFin(String fin);
		
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
	@Query("SELECT i FROM Iniciativa i WHERE (:tituloIniciativa is null or i.tituloIniciativa LIKE %:tituloIniciativa%) and (:descripcion is null or i.descripcion LIKE %:descripcion%) and (:inicio is null or i.inicio = :inicio) and (:fin is null or i.fin = :fin) and (:activa is null or i.activa = :activa)")
	public List<Iniciativa> findByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(@Param("tituloIniciativa") String tituloIniciativa, @Param("descripcion") String descripcion,@Param("inicio") String inicio,@Param("fin") String fin,@Param("activa") Boolean activa);
	
	/**
	 * Find by titulo iniciativa and descripcion.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @return the list
	 */
	public List<Iniciativa> findByTituloIniciativaAndDescripcion(String tituloIniciativa, String descripcion);
}
