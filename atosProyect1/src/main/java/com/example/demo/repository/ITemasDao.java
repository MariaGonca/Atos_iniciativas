package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Iniciativa;
import com.example.demo.model.Temas;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITemasDao.
 */
public interface  ITemasDao extends JpaRepository<Temas, Long>{

		/**
		 * Find by titulo.
		 *
		 * @param titulo the titulo
		 * @return the list
		 */
		public List<Temas> findByTitulo(String titulo);
		
		/**
		 * Find by descripcion.
		 *
		 * @param descripcion the descripcion
		 * @return the list
		 */
		public List<Temas> findByDescripcion(String descripcion);
		
		/**
		 * Find by inicio.
		 *
		 * @param inicio the inicio
		 * @return the list
		 */
		public List<Temas> findByInicio(String inicio);

		/**
		 * Find by fin.
		 *
		 * @param fin the fin
		 * @return the list
		 */
		public List<Temas> findByFin(String fin);
		
		
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
		 * Find by titulo and descripcion and inicio and fin and iniciativa.
		 *
		 * @param titulo the titulo
		 * @param descripcion the descripcion
		 * @param inicio the inicio
		 * @param fin the fin
		 * @param idIniciativa the id iniciativa
		 * @return the list
		 */
		@Query("SELECT i FROM Temas i WHERE (:titulo is null or i.titulo LIKE %:titulo%) and (:descripcion is null or i.descripcion LIKE %:descripcion%) and (:inicio is null or i.inicio = :inicio) and (:fin is null or i.fin = :fin) and (:idIniciativa is null or i.iniciativa IN :idIniciativa)")
		public List<Temas> findByTituloAndDescripcionAndInicioAndFinAndIniciativa(@Param("titulo") String titulo, @Param("descripcion") String descripcion,@Param("inicio") String inicio,@Param("fin") String fin, @Param("idIniciativa") Iniciativa idIniciativa);
				
		
		
		/**
		 * Find by titulo and descripcion.
		 *
		 * @param titulo the titulo
		 * @param descripcion the descripcion
		 * @return the list
		 */
		public List<Temas> findByTituloAndDescripcion(String titulo, String descripcion);
		
		/**
		 * Find by iniciativa id iniciativa.
		 *
		 * @param idIniciativa the id iniciativa
		 * @return the list
		 */
		public List<Temas> findByIniciativaIdIniciativa(Long idIniciativa);
	}

