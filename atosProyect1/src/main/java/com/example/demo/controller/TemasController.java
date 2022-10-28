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

import com.example.demo.model.Iniciativa;
import com.example.demo.model.Temas;
import com.example.demo.services.IIniciativaService;
import com.example.demo.services.ITemasService;
import com.example.demo.services.ITemasServiceImpl;



// TODO: Auto-generated Javadoc
/**
 * The Class TemasController.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TemasController {
	
	/** The iniciativa service. */
	@Autowired
	private IIniciativaService iniciativaService;
	
	/** The temas service. */
	@Autowired
	private ITemasServiceImpl temasService;
	
	/**
	 * List.
	 *
	 * @param idTema the id tema
	 * @return the response entity
	 */
	//Recoge todas las iniciativas
	@GetMapping("/temas")
	public ResponseEntity<List<Temas>> list(Long idTema){
	List<Temas> list = temasService.list();
	return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	/**
	 * Temas by id iniciativa.
	 *
	 * @param idIniciativa the id iniciativa
	 * @return the response entity
	 */
	@GetMapping("/temas/byidIniciativa")
	public ResponseEntity<?> temasByIdIniciativa(@RequestParam Long idIniciativa){
		
		Map<String, Object> response = new HashMap<>();	
		List<Temas> iniciativas;
		try {
			iniciativas = temasService.findByIniciativaIdIniciativa(idIniciativa);	
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(iniciativas == null) {
			response.put("mensaje", "El tema con titulo: ".concat(idIniciativa.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(iniciativas, HttpStatus.OK);
	}	
		
	

//--------------------------------------------------------//
	
	
	/**
 * Temas by titulo.
 *
 * @param titulo the titulo
 * @return the response entity
 */
//Recoge todas las iniciativas por título
	@GetMapping("/temas/byTitulo")
	public ResponseEntity<?> temasByTitulo(@RequestParam String titulo){
		
		Map<String, Object> response = new HashMap<>();	
		List<Temas> temas;
		try {
			temas = temasService.findTitulo(titulo);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(temas == null) {
			response.put("mensaje", "El tema con titulo: ".concat(titulo.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(temas, HttpStatus.OK);
	}	
		
	
	/**
	 * Temas by descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the response entity
	 */
	//Recoge todas las iniciativas por descripción
	@GetMapping("/temas/byDescripcion")
	public ResponseEntity<?> temasByDescripcion(@RequestParam String descripcion){
		
		Map<String, Object> response = new HashMap<>();	
		List<Temas> temas;
		try {
			temas = temasService.findDescripcion(descripcion);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(temas == null) {
			response.put("mensaje", "El tema con descripcion: ".concat(descripcion.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(temas, HttpStatus.OK);
	}	
	
	/**
	 * Temas by inicio.
	 *
	 * @param inicio the inicio
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	//Recoge todas las iniciativas por inicio
	@GetMapping("/temas/byInicio")
	public ResponseEntity<?> temasByInicio(@RequestParam String inicio) throws ParseException{
		Map<String, Object> response = new HashMap<>();	
		List<Temas> temas;
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(inicio, formatter);
			
			System.out.println(localDate);
			
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			String inicioBueno = localDate.format(formatterBueno);
			
			temas = temasService.findInicio(inicioBueno);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(temas == null) {
			response.put("mensaje", "La iniciativa con inicio: ".concat(inicio.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(temas, HttpStatus.OK);
	}	
	
	/**
	 * Temas by fin.
	 *
	 * @param fin the fin
	 * @return the response entity
	 */
	//Recoge todas las iniciativas por fin
	@GetMapping("/temas/byFin")
	public ResponseEntity<?> temasByFin(@RequestParam String fin){
		Map<String, Object> response = new HashMap<>();	
		List<Temas> temas;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(fin, formatter);
			
			System.out.println(localDate);
			
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			String finBueno = localDate.format(formatterBueno);
			temas = temasService.findFin(finBueno);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(temas == null) {
			response.put("mensaje", "El tema con fin: ".concat(fin.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(temas, HttpStatus.OK);
	}	
		
//-------------------------------------------------------//		
		
	
	
	
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	
	
	
	
	
	/**
 * Show.
 *
 * @param idTema the id tema
 * @return the response entity
 */
//Recoge las iniciativas con el id pasado por parámetro
	@GetMapping("/temas/{idTema}/tema")
	public ResponseEntity<?> show(@PathVariable Long idTema){
		Temas temas = null;
		Map<String, Object> response = new HashMap<>();	
		try {
			temas = temasService.findByIdTema(idTema);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(temas == null) {
			response.put("mensaje", "La iniciativa con ID: ".concat(idTema.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Temas>(temas, HttpStatus.OK);
	}
	
	/**
	 * Temas by all params.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param iniciativa the iniciativa
	 * @return the response entity
	 */
	@GetMapping("/temas/filtro")
	public ResponseEntity<?> temasByAllParams(@RequestParam String titulo, String descripcion, String inicio,
			String fin, Iniciativa iniciativa) {
		Map<String, Object> response = new HashMap<>();
		List<Temas> temas;
		System.out.println("Titulo : " + titulo + "\n"
				+"Descripcion : " + descripcion + "\n"
				+"Inicio : " + inicio + "\n"
				+"Fin : " + fin + "\n"
				+"Iniciativa : " + iniciativa) ;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String inicioBueno;
			String finBueno;

			if (titulo.equals("")) {
				titulo = null;
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
			System.out.println("Titulo : " + titulo + "\n"
					+"Descripcion : " + descripcion + "\n"
					+"Inicio : " + inicio + "\n"
					+"Fin : " + fin + "\n"
					+"Iniciativa : " + iniciativa) ;
			
				temas = temasService.findByTituloAndDescripcionAndInicioAndFin(titulo, descripcion,
						inicioBueno, finBueno);
		
				temas = temasService.findByTituloAndDescripcionAndInicioAndFinAndIniciativa(titulo, descripcion,
						inicioBueno, finBueno, iniciativa);
			
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (temas == null) {
			response.put("mensaje", "El tema con fin: ".concat(fin.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(temas, HttpStatus.OK);
	}
	
	/**
	 * Temas by all params without iniciativa.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the response entity
	 */
	@GetMapping("/temas/filtroWithoutIniciativa")
	public ResponseEntity<?> temasByAllParamsWithoutIniciativa(@RequestParam String titulo, String descripcion, String inicio,
			String fin ) {
		Map<String, Object> response = new HashMap<>();
		List<Temas> temas;
		System.out.println("Titulo : " + titulo + "\n"
				+"Descripcion : " + descripcion + "\n"
				+"Inicio : " + inicio + "\n"
				+"Fin : " + fin + "\n") ;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String inicioBueno;
			String finBueno;

			if (titulo.equals("")) {
				titulo = null;
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
			System.out.println("Titulo : " + titulo + "\n"
					+"Descripcion : " + descripcion + "\n"
					+"Inicio : " + inicio + "\n"
					+"Fin : " + fin + "\n"
			) ;
			
				temas = temasService.findByTituloAndDescripcionAndInicioAndFin(titulo, descripcion,
						inicioBueno, finBueno);
		
		
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (temas == null) {
			response.put("mensaje", "El tema con fin: ".concat(fin.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Temas>>(temas, HttpStatus.OK);
	}


	///////////////////////////////////////////////////////

	/**
	 * Search.
	 *
	 * @param idTema the id tema
	 * @return the response entity
	 */
	// Recoge las iniciativas con el id pasado por parámetro
	@GetMapping("/temas/{idTema}")
	public ResponseEntity<?> search(@PathVariable Long idTema) {
		Temas temas = null;
		Map<String, Object> response = new HashMap<>();
		try {
			temas = temasService.findByIdTema(idTema);

			String inicio = temas.getInicio();
			String fin = temas.getFin();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (!fin.equals("")) {
				LocalDate localDate2 = LocalDate.parse(fin, formatter);
				String finBueno = String.format(localDate2.toString(), formatterBueno);
				temas.setFin(finBueno);
			}
			if (!inicio.equals("")) {
				LocalDate localDate = LocalDate.parse(inicio, formatter);
				String inicioBueno = String.format(localDate.toString(), formatterBueno);
				temas.setInicio(inicioBueno);
			}

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (temas == null) {
			response.put("mensaje", "El tema con ID: ".concat(idTema.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Temas>(temas, HttpStatus.OK);
	}

	
	//Crea una iniciativa
//	@PostMapping("/temas")
//	public ResponseEntity<?> create(@Valid @RequestBody Temas temas, BindingResult result) throws ParseException {
//		Temas temasNew = null;
//		Map<String, Object> response = new HashMap<>();	
//		
//            System.out.println(temas);
//            temasNew = temasService.save(temas);
//            System.out.println(temasNew);
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
	
	/**
	 * Creates the.
	 *
	 * @param temas the temas
	 * @param result the result
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	@PostMapping("/temas")
	public ResponseEntity<?> create(@Valid @RequestBody Temas temas, BindingResult result) throws ParseException {
		Temas temasNew = null;
		Map<String, Object> response = new HashMap<>();
		System.out.println(temas.getInicio()); 
		System.out.println("FECHA " + temas.getInicio());
		
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
		
		
		if (!temas.getInicio().equals("")) {
			LocalDate localDateInicio = LocalDate.parse(temas.getInicio(), formatter);
			String inicioBueno = localDateInicio.format(formatterBueno);
			temas.setInicio(inicioBueno);
		}

		if (!temas.getFin().equals("")) {
			LocalDate localDateFin = LocalDate.parse(temas.getFin(), formatter);
			String finBueno = localDateFin.format(formatterBueno);
			temas.setFin(finBueno);
		}

		String i1 = temas.getInicio();
		String f1 = temas.getFin();
		
		
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
					temasNew = temasService.save(temas);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				}
			} else {
				temasNew = temasService.save(temas);
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
	 * @param temas the temas
	 * @param result the result
	 * @param idTema the id tema
	 * @return the response entity
	 * @throws ParseException the parse exception
	 */
	//Actualiza una iniciativa a partir del id
	@PutMapping("/temas/{idTema}")
	public ResponseEntity<?> update(@Valid @RequestBody Temas temas, BindingResult result, @PathVariable Long idTema) throws ParseException {
		Temas temasActual = temasService.findByIdTema(idTema);
		Temas temasUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		if (temasActual.getFin().equals("")) {
			temasActual.setFin(null);
		}
		if (temasActual.getInicio().equals("")) {
			temasActual.setInicio(null);
		}
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo "+err.getDefaultMessage()+ ", "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if(temasActual == null) {
			response.put("mensaje", "El tema con ID: ".concat(idTema.toString().concat(" no se puedo editar, no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	
		try {

			temasActual.setDescripcion(temas.getDescripcion());
			temasActual.setTitulo(temas.getTitulo());
			temasActual.setInicio(temas.getInicio());
			temasActual.setFin(temas.getFin());
			temasActual.setIniciativa(temas.getIniciativa());
			String inicio = temas.getInicio();
			String fin = temas.getFin();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatterBueno = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			if (!temas.getInicio().equals("")) {
				LocalDate localDateInicio = LocalDate.parse(temas.getInicio(), formatter);
				String inicioBueno = localDateInicio.format(formatterBueno);
				temasActual.setInicio(inicioBueno);
			}

			if (!temas.getFin().equals("")) {
				LocalDate localDateFin = LocalDate.parse(temas.getFin(), formatter);
				String finBueno = localDateFin.format(formatterBueno);
				temasActual.setFin(finBueno);
			}
			
			if (!temas.getInicio().equals("") && !temas.getFin().equals("")) {
				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(inicio);
				Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(fin);
				if (date1.after(date2)) {
					System.out.println("La fecha inicio es mas grande");
					response.put("mensaje", "La fecha inicio es posterior a la de finalización");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				} else {
					System.out.println("La fecha fin es mas grande");
					temasUpdated = temasService.save(temasActual);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				}
			} else {
				temasUpdated = temasService.save(temasActual);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			}
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Titulo ya existente");
			response.put("error","Titulo ya existente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	/**
	 * Delete.
	 *
	 * @param idTema the id tema
	 * @return the response entity
	 */
	//Elimina una iniciativa a partir del id
	@DeleteMapping("/temas/{idTema}")
	public ResponseEntity<?> delete(@PathVariable Long idTema) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			temasService.delete(idTema);
		} catch (DataAccessException e) {
			response.put("mensaje", "El tema se ha eliminado con éxito!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		response.put("mensaje", "El tema se ha eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

