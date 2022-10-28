	package com.example.demo.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

import com.example.demo.model.Iniciativa;
import com.example.demo.model.Temas;
import com.example.demo.services.IIniciativaService;

// TODO: Auto-generated Javadoc
/**
 * The Class IniciativaRestController.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IniciativaRestController {

	/** The iniciativa service. */
	@Autowired
	private IIniciativaService iniciativaService;

	/**
	 * Iniciativas.
	 *
	 * @return the list
	 */
	// Recoge todas las iniciativas
	@GetMapping("/iniciativas")
	public List<Iniciativa> iniciativas() {
		return iniciativaService.findAll();
	}

	/**
	 * Iniciativas activas.
	 *
	 * @return the list
	 */
	// Recoge todas las iniciativas activas
	@GetMapping("/iniciativas/activas")
	public List<Iniciativa> iniciativasActivas() {
		return iniciativaService.findActiva();
	}

	/**
	 * Iniciativas inactivas.
	 *
	 * @return the list
	 */
	// Recoge todas las iniciativas activas
	@GetMapping("/iniciativas/inactivas")
	public List<Iniciativa> iniciativasInactivas() {
		return iniciativaService.findInactiva();
	}

//--------------------------------------------------------//

	/**
 * Show temas.
 *
 * @param idIniciativa the id iniciativa
 * @return true, if successful
 */
@GetMapping("/iniciativas/{idIniciativa}/temas")
	public boolean showTemas(@PathVariable Long idIniciativa) {
		Iniciativa iniciativa = null;
		Map<String, Object> response = new HashMap<>();
		List<Temas> temas;
		boolean vacio = false;
		try {
			iniciativa = iniciativaService.findById(idIniciativa);
			temas = iniciativa.getTemas();
			if (temas.isEmpty()) {
				vacio = true;
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		return vacio;
	}

//--------------------------------------------------------//

	/**
 * Iniciativas by titulo iniciativa.
 *
 * @param tituloIniciativa the titulo iniciativa
 * @return the response entity
 */
// Recoge todas las iniciativas por título
	@GetMapping("/iniciativas/byTituloIniciativa")
	public ResponseEntity<?> iniciativasByTituloIniciativa(@RequestParam String tituloIniciativa) {

		Map<String, Object> response = new HashMap<>();
		List<Iniciativa> iniciativa;
		try {
			iniciativa = iniciativaService.findTituloIniciativa(tituloIniciativa);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (iniciativa == null) {
			response.put("mensaje", "La iniciativa con titulo: ".concat(tituloIniciativa.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}

	/**
	 * Iniciativas by descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the response entity
	 */
	// Recoge todas las iniciativas por descripción
	@GetMapping("/iniciativas/byDescripcion")
	public ResponseEntity<?> iniciativasByDescripcion(@RequestParam String descripcion) {

		Map<String, Object> response = new HashMap<>();
		List<Iniciativa> iniciativa;
		try {
			iniciativa = iniciativaService.findDescripcion(descripcion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (iniciativa == null) {
			response.put("mensaje",
					"La iniciativa con descripcion: ".concat(descripcion.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}

	/**
	 * Iniciativas by inicio.
	 *
	 * @param inicio the inicio
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	// Recoge todas las iniciativas por inicio
	@GetMapping("/iniciativas/byInicio")
	public ResponseEntity<?> iniciativasByInicio(@RequestParam String inicio) throws ParseException {
		Map<String, Object> response = new HashMap<>();
		List<Iniciativa> iniciativa;
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate localDate = LocalDate.parse(inicio, formatter);

			System.out.println(localDate);

			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			String inicioBueno = localDate.format(formatterBueno);

			iniciativa = iniciativaService.findInicio(inicioBueno);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (iniciativa == null) {
			response.put("mensaje", "La iniciativa con inicio: ".concat(inicio.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}

	/**
	 * Iniciativas by fin.
	 *
	 * @param fin the fin
	 * @return the response entity
	 */
	// Recoge todas las iniciativas por fin
	@GetMapping("/iniciativas/byFin")
	public ResponseEntity<?> iniciativasByFin(@RequestParam String fin) {
		Map<String, Object> response = new HashMap<>();
		List<Iniciativa> iniciativa;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate localDate = LocalDate.parse(fin, formatter);

			System.out.println(localDate);

			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			String finBueno = localDate.format(formatterBueno);
			iniciativa = iniciativaService.findFin(finBueno);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (iniciativa == null) {
			response.put("mensaje", "La iniciativa con fin: ".concat(fin.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}

//-------------------------------------------------------//		

	/**
 * Iniciativas by all params.
 *
 * @param tituloIniciativa the titulo iniciativa
 * @param descripcion the descripcion
 * @param inicio the inicio
 * @param fin the fin
 * @param activa the activa
 * @return the response entity
 */
// Recoge todas las iniciativas por filtro
	@GetMapping("/iniciativas/filtro")
	public ResponseEntity<?> iniciativasByAllParams(@RequestParam String tituloIniciativa, String descripcion, String inicio,
			String fin, Boolean activa) {
		Map<String, Object> response = new HashMap<>();
		List<Iniciativa> iniciativa;

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String inicioBueno;
			String finBueno;

			if (tituloIniciativa.equals("")) {
				tituloIniciativa = null;
			}
			if (descripcion.equals("")) {
				descripcion = null;
			}
			if (inicio.equals("")) {
				inicioBueno = null;
			} else {
				LocalDate localDate1 = LocalDate.parse(inicio, formatter);
				inicioBueno = localDate1.format(formatterBueno);
			}
			if (fin.equals("")) {
				finBueno = null;
			} else {
				LocalDate localDate = LocalDate.parse(fin, formatter);
				finBueno = localDate.format(formatterBueno);
			}
			if (activa.equals(false)) {
				activa = null;
			}
			iniciativa = iniciativaService.findByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(tituloIniciativa, descripcion,
					inicioBueno, finBueno, activa);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (iniciativa == null) {
			response.put("mensaje", "La iniciativa con fin: ".concat(fin.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Iniciativa>>(iniciativa, HttpStatus.OK);
	}

	///////////////////////////////////////////////////////

	/**
	 * Search.
	 *
	 * @param idIniciativa the id iniciativa
	 * @return the response entity
	 */
	// Recoge las iniciativas con el id pasado por parámetro
	@GetMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> search(@PathVariable Long idIniciativa) {
		Iniciativa iniciativa = null;
		Map<String, Object> response = new HashMap<>();
		try {
			iniciativa = iniciativaService.findById(idIniciativa);

			String inicio = iniciativa.getInicio();
			String fin = iniciativa.getFin();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (!fin.equals("")) {
				LocalDate localDate2 = LocalDate.parse(fin, formatter);
				String finBueno = String.format(localDate2.toString(), formatterBueno);
				iniciativa.setFin(finBueno);
			}
			if (!inicio.equals("")) {
				LocalDate localDate = LocalDate.parse(inicio, formatter);
				String inicioBueno = String.format(localDate.toString(), formatterBueno);
				iniciativa.setInicio(inicioBueno);
			}

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (iniciativa == null) {
			response.put("mensaje", "La iniciativa con ID: ".concat(idIniciativa.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Iniciativa>(iniciativa, HttpStatus.OK);
	}

	/**
	 * Sets the activa.
	 *
	 * @param iniciativa the iniciativa
	 * @param result the result
	 * @param idIniciativa the id iniciativa
	 * @return the response entity
	 */
	// Cambia el booleano Activa a true si está en false, y al revés
	@PostMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> setActiva(@Valid @RequestBody Iniciativa iniciativa, BindingResult result,
			@PathVariable Long idIniciativa) {
		Iniciativa iniciativaActual = iniciativaService.findById(idIniciativa);
		System.out.println(iniciativaActual.getActiva());
		System.out.println("Iniciativa Actual : " + iniciativaActual);
		System.out.println("Iniciativa : " + iniciativa);
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (iniciativaActual == null) {
			response.put("mensaje",
					"La publicación con ID: ".concat(idIniciativa.toString().concat(" no se puede editar, no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			if (iniciativa.getActiva()) {
				
				System.out.println("CONDICION IF : Iniciativa Actual : " + iniciativaActual);
				System.out.println("CONDICION IF : Iniciativa : " + iniciativa);
				iniciativaActual.setActiva(false);
				iniciativaActual = iniciativaService.save(iniciativaActual);
			} else {
				System.out.println("CONDICION ELSE : Iniciativa Actual : " + iniciativaActual);
				System.out.println("CONDICION ELSE : Iniciativa : " + iniciativa);
				iniciativaActual.setActiva(true);
				iniciativaActual = iniciativaService.save(iniciativaActual);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Publicación actualizada con éxtito");
		response.put("foto", iniciativaActual);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	/**
	 * Creates the.
	 *
	 * @param iniciativa the iniciativa
	 * @param result the result
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	// Crea una iniciativa
	@PostMapping("/iniciativas")
	public ResponseEntity<?> create(@Valid @RequestBody Iniciativa iniciativa, BindingResult result)
			throws ParseException {
		Iniciativa iniciativaNew = null;
		Map<String, Object> response = new HashMap<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("mensaje", "Los campos obligatorios estan vacios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		if (!iniciativa.getInicio().equals("")) {
			LocalDate localDateInicio = LocalDate.parse(iniciativa.getInicio(), formatter);
			String inicioBueno = localDateInicio.format(formatterBueno);
			iniciativa.setInicio(inicioBueno);
		}

		if (!iniciativa.getFin().equals("")) {
			LocalDate localDateFin = LocalDate.parse(iniciativa.getFin(), formatter);
			String finBueno = localDateFin.format(formatterBueno);
			iniciativa.setFin(finBueno);
		}

		String i1 = iniciativa.getInicio();
		String f1 = iniciativa.getFin();
		try {
		if (!i1.equals("") && !f1.equals("")) {

			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(i1);
			Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(f1);

			if (date1.after(date2)) {
				System.out.println("La fecha inicio es mas grande");
				response.put("mensaje", "La fecha inicio es posterior a la de finalización");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				System.out.println("La fecha fin es mas grande");
				iniciativaNew = iniciativaService.save(iniciativa);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			}
		} else {
			iniciativaNew = iniciativaService.save(iniciativa);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}} catch (DataAccessException e) {
			response.put("mensaje", "Titulo ya existente");
			response.put("error","Titulo ya existente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Update.
	 *
	 * @param iniciativa the iniciativa
	 * @param result the result
	 * @param idIniciativa the id iniciativa
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	// Actualiza una iniciativa a partir del id
	@PutMapping("/iniciativas/{idIniciativa}")
	public ResponseEntity<?> update(@Valid @RequestBody Iniciativa iniciativa, BindingResult result, @PathVariable Long idIniciativa) throws ParseException {
		
		Iniciativa iniciativaActual = iniciativaService.findById(idIniciativa);
		
		if (iniciativaActual.getFin().equals("")) {
			iniciativaActual.setFin(null);
		}
		if (iniciativaActual.getInicio().equals("")) {
			iniciativaActual.setInicio(null);
		}
		
		Iniciativa iniciativaUpdated = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {	

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("mensaje", "Los campos obligatorios estan vacios");///
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (iniciativaActual == null) {
			response.put("mensaje",	"La iniciativa con ID: ".concat(idIniciativa.toString().concat(" no se puedo editar, no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			iniciativaActual.setDescripcion(iniciativa.getDescripcion());
			iniciativaActual.setTituloIniciativa(iniciativa.getTituloIniciativa());
			iniciativaActual.setActiva(iniciativa.getActiva());
			iniciativaActual.setInicio(iniciativa.getInicio());
			iniciativaActual.setFin(iniciativa.getFin());
			String inicio = iniciativa.getInicio();
			String fin = iniciativa.getFin();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			if (!iniciativa.getInicio().equals("")) {
				LocalDate localDateInicio = LocalDate.parse(iniciativa.getInicio(), formatter);
				String inicioBueno = localDateInicio.format(formatterBueno);
				iniciativaActual.setInicio(inicioBueno);
			}

			if (!iniciativa.getFin().equals("")) {
				LocalDate localDateFin = LocalDate.parse(iniciativa.getFin(), formatter);
				String finBueno = localDateFin.format(formatterBueno);
				iniciativaActual.setFin(finBueno);
			}

			if (!iniciativa.getInicio().equals("") && !iniciativa.getFin().equals("")) {
				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(inicio);
				Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fin);
				if (date1.after(date2)) {
					System.out.println("La fecha inicio es mas grande");
					response.put("mensaje", "La fecha inicio es posterior a la de finalización");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				} else {
					System.out.println("La fecha fin es mas grande");
					iniciativaUpdated = iniciativaService.save(iniciativaActual);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				}
			} else {
				iniciativaUpdated = iniciativaService.save(iniciativaActual);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			}

			// iniciativaUpdated = iniciativaService.save(iniciativaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Titulo ya existente");
			response.put("error","Titulo ya existente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete.
	 *
	 * @param idIniciativa the id iniciativa
	 * @return the response entity
	 */
	// Elimina una iniciativa a partir del id
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
