package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
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

import com.example.demo.model.ERole;
import com.example.demo.model.Iniciativa;
import com.example.demo.model.Role;
import com.example.demo.model.Temas;
import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.service.UserDetailsImpl;
import com.example.demo.security.service.userInterface;
import com.example.demo.security.service.userservi;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthController.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	/** The authentication manager. */
	@Autowired
	AuthenticationManager authenticationManager;

	/** The user repository. */
	@Autowired
	UserRepository userRepository;

	/** The role repository. */
	@Autowired
	RoleRepository roleRepository;

	/** The user in. */
	@Autowired
	userInterface userIn;

	/** The userservice. */
	@Autowired
	userservi userservice;

	/** The encoder. */
	@Autowired
	PasswordEncoder encoder;

	/** The jwt utils. */
	@Autowired
	JwtUtils jwtUtils;

	/**
	 * Authenticate user.
	 *
	 * @param loginRequest the login request
	 * @return the response entity
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	/**
	 * List.
	 *
	 * @return the response entity
	 */
	@GetMapping("/lista")
	public ResponseEntity<List<User>> list() {
		List<User> list = userservice.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		if (!userservice.existsById(id))
			return new ResponseEntity(("no existe"), HttpStatus.NOT_FOUND);
		userservice.delete(id);
		return new ResponseEntity(("producto eliminado"), HttpStatus.OK);
	}

	/**
	 * Update user.
	 *
	 * @param id the id
	 * @param users the users
	 * @return the response entity
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User users) {

		User usuario = userservice.findById(id).orElseThrow();

		usuario.setUsername(users.getUsername());

		usuario.setLocation(users.getLocation());
		usuario.setDas(users.getDas());
		usuario.setCeco(users.getCeco());
		usuario.setCenter(users.getCenter());

		usuario.setApellidos(users.getApellidos());

		User updatedEmployee = userIn.save(usuario);
		return ResponseEntity.ok(updatedEmployee);
	}

	/**
	 * Gets the login by id.
	 *
	 * @param id the id
	 * @return the login by id
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getLoginById(@PathVariable Long id) {
		User user = userRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(user);
	}

	/**
	 * Register user.
	 *
	 * @param users the users
	 * @return the response entity
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User users) {
		if (userRepository.existsByUsername(users.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username ya existente!"));
		}
		if (userRepository.existsByEmail(users.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email ya existente!"));
		}
// Create new user's account
		User user;
		user = users;
		String strRoles = users.getU();
		System.out.println(user.getU() + "diwuehuf");
		System.out.println(strRoles);
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
			roles.add(userRole);
		} else {

			switch (strRoles) {
			case "gestor":
				Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
				roles.add(adminRole);
				break;
			case "tutor":
				Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
						.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
				roles.add(modRole);
				break;
			default:
				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
				roles.add(userRole);
			}
			;
		}
		user.setRoles(roles);
		userservice.save(user);
		return ResponseEntity.ok(new MessageResponse("Usuario registrado correctamente!"));
	}

	/**
	 * Users by all params.
	 *
	 * @param center the center
	 * @param username the username
	 * @param apellidos the apellidos
	 * @param u the u
	 * @param location the location
	 * @param iniciativaUser the iniciativa user
	 * @return the response entity
	 */
	@GetMapping("/users/filtro")
	public ResponseEntity<?> usersByAllParams(@RequestParam String center, String username, String apellidos, String u,
			String location, Iniciativa iniciativaUser) {
		Map<String, Object> response = new HashMap<>();
		List<User> user;

		System.out.println("center : " + center + "\n" + "username : " + username + "\n" + "apellidos : " + apellidos
				+ "\n" + "u : " + u + "\n" + "iniciativaUser : " + iniciativaUser.getIdIniciativa() + "\n"
				+ "location : " + location);

		try {

			if (center.equals("")) {
				center = null;
			}
			if (username.equals("")) {
				username = null;
			}

			if (apellidos.equals("")) {
				apellidos = null;
			}
			if (u.equals("")) {
				u = null;
			}
			if (location.equals("")) {
				location = null;
			}

			System.out.println("center : " + center + "\n" + "username : " + username + "\n" + "apellidos : "
					+ apellidos + "\n" + "u : " + u + "\n" + "iniciativaUser : " + iniciativaUser.getIdIniciativa()
					+ "\n" + "location : " + location);

			user = userIn.findByCenterAndUsernameAndApellidosAndUAndLocationAndIniciativaUserIdIniciativa(center,
					username, apellidos, u, location, iniciativaUser);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (user == null) {
			response.put("mensaje", "El usuario no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	/**
	 * User by all params without iniciativa.
	 *
	 * @param center the center
	 * @param username the username
	 * @param apellidos the apellidos
	 * @param u the u
	 * @param location the location
	 * @return the response entity
	 */
	@GetMapping("/users/filtroSin")
	public ResponseEntity<?> userByAllParamsWithoutIniciativa(@RequestParam String center, String username,
			String apellidos, String u, String location) {
		Map<String, Object> response = new HashMap<>();
		List<User> user;

		try {

			if (center.equals("")) {
				center = null;
			}
			if (username.equals("")) {
				username = null;
			}

			if (apellidos.equals("")) {
				apellidos = null;
			}
			if (u.equals("")) {
				u = null;
			}
			if (location.equals("")) {
				location = null;
			}

			user = userIn.findByCenterAndUsernameAndApellidosAndUAndLocation(center, username, apellidos, u, location);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (user == null) {
			response.put("mensaje", "El usuario no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

}
