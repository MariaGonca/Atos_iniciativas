package com.demo.payload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Iniciativa;
import com.example.demo.repository.IIniciativaDao;

@Service
public class IIniciativaServiceImpl  implements IIniciativaService{

	@Autowired
	private IIniciativaDao iniciativaoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Iniciativa> findAll() {
		return iniciativaoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iniciativa findById(Long id) {
		return iniciativaoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Iniciativa save(Iniciativa iniciativa) {
		return iniciativaoDao.save(iniciativa);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iniciativaoDao.deleteById(id);
	}

	@Override
	public List<Iniciativa> findActiva() {
		return iniciativaoDao.findByActivaTrue();
	}
	
	@Override
	public List<Iniciativa> findInactiva() {
		return iniciativaoDao.findByActivaFalse();
	}
	
	@Override
	public List<Iniciativa> findTitulo(String titulo) {
		return iniciativaoDao.findByTitulo(titulo);
	}

	@Override
	public List<Iniciativa> findDescripcion(String descripcion) {
		return iniciativaoDao.findByDescripcion(descripcion);
	}

	@Override
	public List<Iniciativa> findInicio(String inicio) {
		return iniciativaoDao.findByInicio(inicio);
	}

	@Override
	public List<Iniciativa> findFin(String inicio) {
		return iniciativaoDao.findByFin(inicio);
	}
	
	@Override
	public List<Iniciativa> findByTituloAndDescripcion(String titulo, String descripcion) {
		return iniciativaoDao.findByTituloAndDescripcion(titulo, descripcion);
	}

	@Override
	public List<Iniciativa> findByTituloAndDescripcionAndInicioAndFin(String titulo, String descripcion,
			String inicio, String fin) {
		return iniciativaoDao.findByTituloAndDescripcionAndInicioAndFin(titulo, descripcion, inicio, fin);
	}

	@Override
	public List<Iniciativa> findByTituloAndDescripcionAndInicioAndFinAndActiva(String titulo, String descripcion,
			String inicio, String fin, Boolean activa) {
			
		return iniciativaoDao.findByTituloAndDescripcionAndInicioAndFinAndActiva(titulo, descripcion, inicio, fin, activa);
	}

}
