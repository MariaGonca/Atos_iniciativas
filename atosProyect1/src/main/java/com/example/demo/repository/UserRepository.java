package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Iniciativa;
import com.example.demo.model.User;


// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	Optional<User> findByUsername(String username);

	/**
	 * Exists by username.
	 *
	 * @param username the username
	 * @return the boolean
	 */
	Boolean existsByUsername(String username);

	/**
	 * Exists by email.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	Boolean existsByEmail(String email);
	
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
    @Query("SELECT i FROM User i WHERE (:center is null or i.center LIKE %:center%) and (:username is null or i.username LIKE %:username%) and (:apellidos is null or i.apellidos LIKE %:apellidos%) and (:u is null or i.u LIKE %:u%) and (:location is null or i.location LIKE %:location%) and (:idIniciativa is null or i.iniciativaUser IN :idIniciativa)")
	public List<User> findByCenterAndUsernameAndApellidosAndUAndLocationAndIniciativaUserIdIniciativa(@Param("center") String center, @Param("username") String username,@Param("apellidos") String apellidos,@Param("u") String u, @Param("location") String location, @Param("idIniciativa") Iniciativa idIniciativa);
		

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
	@Query("SELECT i FROM User i WHERE (:center is null or i.center LIKE %:center%) and (:username is null or i.username LIKE %:username%) and (:apellidos is null or i.apellidos LIKE %:apellidos%) and (:u is null or i.u LIKE %:u%) and (:location is null or i.location LIKE %:location%)")
	public List<User> findByCenterAndUsernameAndApellidosAndUAndLocation(@Param("center") String center, @Param("username") String username,@Param("apellidos") String apellidos,@Param("u") String u,  @Param("location") String location);
			

















}
	

