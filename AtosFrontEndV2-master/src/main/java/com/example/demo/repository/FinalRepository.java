package com.example.demo.repository;
		
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Final;

	public interface FinalRepository extends JpaRepository<Final, Long> {
		 List<Final> findByPublicado(boolean publicado);
		 List<Final> findByTituloContaining(String titulo);
	
}
	

