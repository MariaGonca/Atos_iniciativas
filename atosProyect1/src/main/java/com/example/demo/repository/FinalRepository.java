package com.example.demo.repository;
		
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Final;

	// TODO: Auto-generated Javadoc
/**
	 * The Interface FinalRepository.
	 */
	public interface FinalRepository extends JpaRepository<Final, Long> {
		 
 		/**
 		 * Find by publicado.
 		 *
 		 * @param publicado the publicado
 		 * @return the list
 		 */
 		List<Final> findByPublicado(boolean publicado);
		 
 		/**
 		 * Find by titulo containing.
 		 *
 		 * @param titulo the titulo
 		 * @return the list
 		 */
 		List<Final> findByTituloContaining(String titulo);
	
}
	

