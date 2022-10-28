package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

import com.demo.payload.service.IIniciativaService;
import com.example.demo.model.Iniciativa;
import com.example.demo.model.Temas;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IniciativaRestController {
	
	
	@Autowired
	private IIniciativaService iniciativaService;
	
	
	//Recoge todas las iniciativas
	@GetMapping("/iniciativas")
	public List<Iniciativa> iniciativas(){
		return iniciativaService.findAll();
	}
	
	
	//Recoge todas las iniciativas activas
	@GetMapping("/iniciativas/activas")
	public List<Iniciativa> iniciativasActivas(){
		return iniciativaService.findActiva();
	}
	
	//Recoge todas las iniciativas activas
	@GetMapping("/iniciativas/inactivas")
	public List<Iniciativa> iniciativasInactivas(){
		return iniciativaService.findInactiva();
	}
	
//--------------------------------------------------------//
	
	
	@GetMapping("/iniciativas/{idIniciativa}/temas")
	public boolean showTemas(@PathVariable Long idIniciativa){
		Iniciativa iniciativa = null;
		Map<String, Object> response = new HashMap<>();	
		List<Temas> temas;
		boolean vacio = false;
		try {
			iniciativa = iniciativaService.findById(idIniciativa);
			temas = iniciativa.getTemas();
			if(temas.isEmpty()){
				vacio = true;
			}
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return vacio;
	}

//--------------------------------------------------------//
	
	
	//Recoge todas las iniciativas por título
	@GetMapping("/iniciativas/byTitulo")
	public ResponseEntity<?> iniciativasByTitulo(@RequestParam String titulo){
		
		Map<String, Object> response = new HashMap<>();	
		List<Iniciativa> iniciativa;
		try {
			iniciativa = iniciativaService.findTitulo(titulo);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(iniciativa == null) {
			response.put("mensaje", "La iniciativa con titulo: ".concat(titulo.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}	
		
	
	//Recoge todas las iniciativas por descripción
	@GetMapping("/iniciativas/byDescripcion")
	public ResponseEntity<?> iniciativasByDescripcion(@RequestParam String descripcion){
		
		Map<String, Object> response = new HashMap<>();	
		List<Iniciativa> iniciativa;
		try {
			iniciativa = iniciativaService.findDescripcion(descripcion);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(iniciativa == null) {
			response.put("mensaje", "La iniciativa con descripcion: ".concat(descripcion.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}	
	
	//Recoge todas las iniciativas por inicio
	@GetMapping("/iniciativas/byInicio")
	public ResponseEntity<?> iniciativasByInicio(@RequestParam String inicio) throws ParseException{
		Map<String, Object> response = new HashMap<>();	
		List<Iniciativa> iniciativa;
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(inicio, formatter);
			
			System.out.println(localDate);
			
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			String inicioBueno = localDate.format(formatterBueno);
			
			iniciativa = iniciativaService.findInicio(inicioBueno);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(iniciativa == null) {
			response.put("mensaje", "La iniciativa con inicio: ".concat(inicio.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}	
	
	//Recoge todas las iniciativas por fin
	@GetMapping("/iniciativas/byFin")
	public ResponseEntity<?> iniciativasByFin(@RequestParam String fin){
		Map<String, Object> response = new HashMap<>();	
		List<Iniciativa> iniciativa;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(fin, formatter);
			
			System.out.println(localDate);
			
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			String finBueno = localDate.format(formatterBueno);
			iniciativa = iniciativaService.findFin(finBueno);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(iniciativa == null) {
			response.put("mensaje", "La iniciativa con fin: ".concat(fin.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}	
		
//-------------------------------------------------------//		
		
	
	
	
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	
	
	
	
	
	//Recoge las iniciativas con el id pasado por parámetro
	@GetMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> show(@PathVariable Long idIniciativa){
		Iniciativa iniciativa = null;
		Map<String, Object> response = new HashMap<>();	
		try {
			iniciativa = iniciativaService.findById(idIniciativa);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(iniciativa == null) {
			response.put("mensaje", "La iniciativa con ID: ".concat(idIniciativa.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Iniciativa>(iniciativa, HttpStatus.OK);
	}
	
	
	
	
	
	
	//Cambia el booleano Activa a true si está en false, y al revés	
	@PostMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> setActiva(@Valid @RequestBody Iniciativa iniciativa, BindingResult result, @PathVariable Long idIniciativa) {
		Iniciativa iniciativaActual = iniciativaService.findById(idIniciativa);
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo "+err.getDefaultMessage()+ ", "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if(iniciativaActual == null) {
			response.put("mensaje", "La publicación con ID: ".concat(idIniciativa.toString().concat(" no se puede editar, no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	
		try {
			if(iniciativaActual.getActiva()) {
				iniciativaActual.setActiva(false);
				iniciativaActual = iniciativaService.save(iniciativaActual);
			}else {
				iniciativaActual.setActiva(true);
				iniciativaActual = iniciativaService.save(iniciativaActual);
			}
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Publicación actualizada con éxtito");
		response.put("foto", iniciativaActual);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	
	
	//Crea una iniciativa
	@PostMapping("/iniciativas")
	public ResponseEntity<?> create(@Valid @RequestBody Iniciativa iniciativa, BindingResult result) throws ParseException {
		Iniciativa iniciativaNew = null;
		Map<String, Object> response = new HashMap<>();	
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo "+err.getDefaultMessage()+ ", "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {			
			 Date inicioFecha = sdf.parse(iniciativa.getInicio());
        Date finFecha = sdf.parse(iniciativa.getFin());

        if(inicioFecha.after(finFecha)) {
            System.out.println("La fecha inicio es mas grande");
            response.put("mensaje", "Error al actualizar en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            System.out.println("La fecha fin es mas grande");
            iniciativaNew = iniciativaService.save(iniciativa);
        }			
			
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Publicación realizada con éxtito");
		response.put("iniciativa", iniciativaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	
	//Actualiza una iniciativa a partir del id
	@PutMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> update(@Valid @RequestBody Iniciativa iniciativa, BindingResult result, @PathVariable Long idIniciativa) throws ParseException {
		Iniciativa iniciativaActual = iniciativaService.findById(idIniciativa);
		Iniciativa iniciativaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo "+err.getDefaultMessage()+ ", "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if(iniciativaActual == null) {
			response.put("mensaje", "La publicación con ID: ".concat(idIniciativa.toString().concat(" no se puedo editar, no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	
		try {

			iniciativaActual.setDescripcion(iniciativa.getDescripcion());
			iniciativaActual.setTitulo(iniciativa.getTitulo());
			iniciativaActual.setInicio(iniciativa.getInicio());
			iniciativaActual.setFin(iniciativa.getFin());
			iniciativaActual.setActiva(iniciativa.getActiva());

			 Date inicioFecha = sdf.parse(iniciativa.getInicio());
		     Date finFecha = sdf.parse(iniciativa.getFin());

		        if(inicioFecha.after(finFecha)) {
		            System.out.println("La fecha inicio es mas grande");
		            response.put("mensaje", "La fecha inicio es posterior a la fecha de fin");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		            
		        }else {
		            System.out.println("La fecha fin es mas grande");
		            iniciativaUpdated = iniciativaService.save(iniciativaActual);
		        }
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Iniciativa actualizada con éxtito");
		response.put("iniciativa", iniciativaUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	
	//Elimina una iniciativa a partir del id
	@DeleteMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> delete(@PathVariable Long idIniciativa) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			iniciativaService.delete(idIniciativa);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el publicación de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La iniciativa se ha eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
