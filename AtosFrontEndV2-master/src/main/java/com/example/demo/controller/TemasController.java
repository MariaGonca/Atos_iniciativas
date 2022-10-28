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

import com.example.demo.model.Temas;
import com.example.demo.repository.TemasRepository;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TemasController {
	@Autowired
	TemasRepository temasRepository;

	@GetMapping("/temas")
	public ResponseEntity<List<Temas>> getTodosTemas(@RequestParam(required = false) String titulo) {
		try {
			List<Temas> temas = new ArrayList<Temas>();
			if (titulo == null)
				temasRepository.findAll().forEach(temas::add);
			else
				temasRepository.findByTituloContaining(titulo).forEach(temas::add);

			if (temas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(temas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/temas/{id}")
	public ResponseEntity<Temas> getTemasesPorId(@PathVariable("id") long id) {
		Optional<Temas> temasData = temasRepository.findById(id);
		if (temasData.isPresent()) {
			return new ResponseEntity<>(temasData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/temas")
	public ResponseEntity<Temas> crearTemas(@RequestBody Temas temas) {
		try {
			Temas _temas = temasRepository.save(new Temas(temas.getTitulo(), temas.getDescripcion(), temas.getFechaInicio(), temas.getFechaFin(), temas.getIniciativa()));

			return new ResponseEntity<>(_temas, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/temas/{id}")
	public ResponseEntity<Temas> actualizarTemas(@PathVariable("id") long id, @RequestBody Temas tutorial) {
		Optional<Temas> temasData = temasRepository.findById(id);
		if (temasData.isPresent()) {
			Temas _temas = temasData.get();
			_temas.setTitulo(tutorial.getTitulo());
			_temas.setDescripcion(tutorial.getDescripcion());
			_temas.setFechaInicio(tutorial.getFechaInicio());
			_temas.setFechaFin(tutorial.getFechaFin());
			_temas.setIniciativa(tutorial.getIniciativa());
			return new ResponseEntity<>(temasRepository.save(_temas), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/temas/{id}")
	public ResponseEntity<HttpStatus> eliminarTemas(@PathVariable("id") long id) {
		try {
			temasRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/temas")
	public ResponseEntity<HttpStatus> eliminarTodosTemas() {
		try {
			temasRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
