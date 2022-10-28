package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Final;
import com.example.demo.repository.FinalRepository;

	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)//TODO
	@RestController
	@RequestMapping("/api") //TODO
	public class FinalController {
		
		  @Autowired
		  FinalRepository tutorialRepository;

		  @GetMapping("/tutoriales")
		  public ResponseEntity<List<Final>> getTodosTutoriales(@RequestParam(required = false) String titulo) {
			  try {
			      List<Final> tutoriales = new ArrayList<Final>();

			      if (titulo == null)
			        tutorialRepository.findAll().forEach(tutoriales::add);
			      else
			        tutorialRepository.findByTituloContaining(titulo).forEach(tutoriales::add);

			      if (tutoriales.isEmpty()) {
			        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			      }

			      return new ResponseEntity<>(tutoriales, HttpStatus.OK);
			    } catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			    }
		  }

		  @GetMapping("/tutoriales/{id}")
		  public ResponseEntity<Final> getTutorialPorId(@PathVariable("id") long id) {
			  Optional<Final> tutorialData = tutorialRepository.findById(id);

			    if (tutorialData.isPresent()) {
			      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
			    } else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
		  }

		  @PostMapping("/tutoriales")
		  public ResponseEntity<Final> crearTutorial(@RequestBody Final tutorial) {
			  try {
			      Final _tutorial = tutorialRepository.save(new Final(tutorial.getTitulo(), tutorial.getDescripcion(), tutorial.getImagen(), false));
			      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
			    } catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			    }
		  }

		  @PutMapping("/tutoriales/{id}")
		  public ResponseEntity<Final> actualizarTutorial(@PathVariable("id") long id, @RequestBody Final tutorial) {
			  Optional<Final> tutorialData = tutorialRepository.findById(id);

			    if (tutorialData.isPresent()) {
			      Final _tutorial = tutorialData.get();
			      _tutorial.setTitulo(tutorial.getTitulo());
			      _tutorial.setDescripcion(tutorial.getDescripcion());
			      _tutorial.setImagen(tutorial.getImagen());
			      _tutorial.setPublicado(tutorial.esPublicado());
			      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
			    } else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
		  }

		  @DeleteMapping("/tutoriales/{id}")
		  public ResponseEntity<HttpStatus> eliminarTutorial(@PathVariable("id") long id) {
			  try {
			      tutorialRepository.deleteById(id);
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    } catch (Exception e) {
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			    }
		  }

		  @DeleteMapping("/tutoriales")
		  public ResponseEntity<HttpStatus> eliminarTodosTutoriales() {
			  try {
			      tutorialRepository.deleteAll();
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    } catch (Exception e) {
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			    }
		  }

		  @GetMapping("/tutoriales/publicado")
		  public ResponseEntity<List<Final>> findByPublished() {
			  try {
			      List<Final> tutoriales = tutorialRepository.findByPublicado(true);

			      if (tutoriales.isEmpty()) {
			        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			      }
			      return new ResponseEntity<>(tutoriales, HttpStatus.OK);
			    } catch (Exception e) {
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			    }
			  
		  }

		  
}


