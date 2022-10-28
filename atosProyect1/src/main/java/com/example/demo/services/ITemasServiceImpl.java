package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Iniciativa;
import com.example.demo.model.Temas;
import com.example.demo.repository.ITemasDao;

// TODO: Auto-generated Javadoc
/**
 * The Class ITemasServiceImpl.
 */
@Service
public class ITemasServiceImpl implements ITemasService{

	/** The temas dao. */
	@Autowired
	private ITemasDao temasDao;
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Temas> findAll() {
		return temasDao.findAll();
	}

	
	
	/**
	 * Find by id tema.
	 *
	 * @param idTema the id tema
	 * @return the temas
	 */
	@Override
	@Transactional(readOnly = true)
	public Temas findByIdTema(Long idTema) {
		return temasDao.findById(idTema).orElse(null);
	}

	/**
	 * Save.
	 *
	 * @param temas the temas
	 * @return the temas
	 */
	@Override
	@Transactional
	public Temas save(Temas temas) {
		return temasDao.save(temas);
	}

	/**
	 * Delete.
	 *
	 * @param idTema the id tema
	 */
	@Override
	@Transactional
	public void delete(Long idTema) {
		temasDao.deleteById(idTema);
	}

	/**
	 * Find titulo.
	 *
	 * @param titulo the titulo
	 * @return the list
	 */
	@Override
	public List<Temas> findTitulo(String titulo) {
		return temasDao.findByTitulo(titulo);
	}

	/**
	 * Find descripcion.
	 *
	 * @param descripcion the descripcion
	 * @return the list
	 */
	@Override
	public List<Temas> findDescripcion(String descripcion) {
		return temasDao.findByDescripcion(descripcion);
	}

	/**
	 * Find inicio.
	 *
	 * @param inicio the inicio
	 * @return the list
	 */
	@Override
	public List<Temas> findInicio(String inicio) {
		return temasDao.findByInicio(inicio);
	}

	/**
	 * Find fin.
	 *
	 * @param fin the fin
	 * @return the list
	 */
	@Override
	public List<Temas> findFin(String fin) {
		return temasDao.findByFin(fin);
	}

	/**
	 * Find by titulo and descripcion.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @return the list
	 */
	@Override
	public List<Temas> findByTituloAndDescripcion(String titulo, String descripcion) {
		return temasDao.findByTituloAndDescripcion(titulo, descripcion);
	}

	/**
	 * Find by titulo and descripcion and inicio and fin and iniciativa.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param iniciativa the iniciativa
	 * @return the list
	 */
	@Override
	public List<Temas> findByTituloAndDescripcionAndInicioAndFinAndIniciativa(String titulo, String descripcion, String inicio,
			String fin, Iniciativa iniciativa) {
		return temasDao.findByTituloAndDescripcionAndInicioAndFinAndIniciativa(titulo, descripcion, inicio, fin, iniciativa);
	}

	/**
	 * List.
	 *
	 * @return the list
	 */
	@Override
	public List<Temas> list() {
		return temasDao.findAll();
	}



	/**
	 * Find by iniciativa id iniciativa.
	 *
	 * @param idIniciativa the id iniciativa
	 * @return the list
	 */
	@Override
	public List<Temas> findByIniciativaIdIniciativa(Long idIniciativa) {
		return temasDao.findByIniciativaIdIniciativa(idIniciativa);
	}



	/**
	 * Find by titulo and descripcion and inicio and fin.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the list
	 */
	@Override
	public List<Temas> findByTituloAndDescripcionAndInicioAndFin(String titulo, String descripcion, String inicio,
			String fin) {
		return temasDao.findByTituloAndDescripcionAndInicioAndFin(titulo, descripcion, inicio, fin);
	}
}

