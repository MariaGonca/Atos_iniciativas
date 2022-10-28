package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Iniciativa;
import com.example.demo.repository.IIniciativaDao;

// TODO: Auto-generated Javadoc
/**
 * The Class IIniciativaServiceImpl.
 */
@Service
public class IIniciativaServiceImpl  implements IIniciativaService{

	/** The iniciativao dao. */
	@Autowired
	private IIniciativaDao iniciativaoDao;
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Iniciativa> findAll() {
		return iniciativaoDao.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the iniciativa
	 */
	@Override
	@Transactional(readOnly = true)
	public Iniciativa findById(Long id) {
		return iniciativaoDao.findById(id).orElse(null);
	}

	/**
	 * Save.
	 *
	 * @param iniciativa the iniciativa
	 * @return the iniciativa
	 */
	@Override
	@Transactional
	public Iniciativa save(Iniciativa iniciativa) {
		return iniciativaoDao.save(iniciativa);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		iniciativaoDao.deleteById(id);
	}

	/**
	 * Find activa.
	 *
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findActiva() {
		return iniciativaoDao.findByActivaTrue();
	}
	
	/**
	 * Find inactiva.
	 *
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findInactiva() {
		return iniciativaoDao.findByActivaFalse();
	}
	
	/**
	 * Find titulo iniciativa.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findTituloIniciativa(String tituloIniciativa) {
		return iniciativaoDao.findByTituloIniciativa(tituloIniciativa);
	}

	/**
	 * Find descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findDescripcion(String descripcion) {
		return iniciativaoDao.findByDescripcion(descripcion);
	}

	/**
	 * Find inicio.
	 *
	 * @param inicio the inicio
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findInicio(String inicio) {
		return iniciativaoDao.findByInicio(inicio);
	}

	/**
	 * Find fin.
	 *
	 * @param inicio the inicio
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findFin(String inicio) {
		return iniciativaoDao.findByFin(inicio);
	}
	
	/**
	 * Find by titulo iniciativa and descripcion.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findByTituloIniciativaAndDescripcion(String tituloIniciativa, String descripcion) {
		return iniciativaoDao.findByTituloIniciativaAndDescripcion(tituloIniciativa, descripcion);
	}



	/**
	 * Find by titulo iniciativa and descripcion and inicio and fin and activa.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param activa the activa
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(String tituloIniciativa, String descripcion,
			String inicio, String fin, Boolean activa) {	
		return iniciativaoDao.findByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(tituloIniciativa, descripcion, inicio, fin, activa);
	}

	/**
	 * Find by titulo iniciativa and descripcion and inicio and fin.
	 *
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the list
	 */
	@Override
	public List<Iniciativa> findByTituloIniciativaAndDescripcionAndInicioAndFin(String tituloIniciativa, String descripcion, String inicio,
			String fin) {
		return iniciativaoDao.findByTituloIniciativaAndDescripcionAndInicioAndFin(tituloIniciativa, descripcion, inicio, fin);
	}



}

