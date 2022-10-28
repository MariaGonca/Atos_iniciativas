package com.example.demo.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Iniciativa;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


// TODO: Auto-generated Javadoc
/**
 * The Class userservi.
 */
@Service
public class userservi implements userInterface {

	/** The repo. */
	@Autowired
	private UserRepository repo;
	
	/**
	 * List.
	 *
	 * @return the list
	 */
	public List<User> list(){
        return repo.findAll();
    }

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<User> findById(Long id) {
		
	return repo.findById(id);
	}
	
	
	/**
	 * Save.
	 *
	 * @param p the p
	 * @return the user
	 */
	public User save(User p) {
	return repo.save(p);
	}

	/**
	 * Listar.
	 *
	 * @return the list
	 */
	@Override
	public List<User> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Listar id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<User> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * User.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	@Override
	public User user(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Register.
	 *
	 * @param p the p
	 * @return the string
	 */
	@Override
	public String register(User p) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Find by center and username and apellidos and U and location and iniciativa user id iniciativa.
	 *
	 * @param center the center
	 * @param username the username
	 * @param apellidos the apellidos
	 * @param u the u
	 * @param location the location
	 * @param idIniciativa the id iniciativa
	 * @return the list
	 */
	@Override
	public List<User> findByCenterAndUsernameAndApellidosAndUAndLocationAndIniciativaUserIdIniciativa(String center,
			String username, String apellidos, String u, String location,  Iniciativa idIniciativa) {
		// TODO Auto-generated method stub
		return repo.findByCenterAndUsernameAndApellidosAndUAndLocationAndIniciativaUserIdIniciativa(center, username, apellidos, u, location, idIniciativa);
	}

	/**
	 * Find by center and username and apellidos and U and location.
	 *
	 * @param center the center
	 * @param username the username
	 * @param apellidos the apellidos
	 * @param u the u
	 * @param location the location
	 * @return the list
	 */
	@Override
	public List<User> findByCenterAndUsernameAndApellidosAndUAndLocation(String center, String username,
			String apellidos, String u, String location) {
		// TODO Auto-generated method stub
		return repo.findByCenterAndUsernameAndApellidosAndUAndLocation(center, username, apellidos, u, location);
	}

	
}
