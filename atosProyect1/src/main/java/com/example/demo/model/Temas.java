package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// TODO: Auto-generated Javadoc
/**
 * The Class Temas.
 */
@Entity
@Table(name = "temas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Temas implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id tema. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(pattern = "idTema")
	private Long idTema;
	
	/** The titulo. */
	@Column(name = "TITULO", unique=true)
	@NotNull	
	@JsonFormat(pattern = "titulo")
	@NotEmpty
	private String titulo;
	
	/** The descripcion. */
	@Column(name = "DESCRIPCION")
	@JsonFormat(pattern = "descripcion")
	@Nullable
	@NotEmpty
	private String descripcion;
	
	/** The inicio. */
	@Column(name = "INICIO", nullable = true)
	@Nullable
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String inicio;
	
	/** The fin. */
	@Column(name = "FIN", nullable = true)
	@Nullable
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String fin;
	
	/** The iniciativa. */
	@OneToOne(fetch = FetchType.LAZY)
	@NotNull
	@ElementCollection
	@JoinColumn(name = "ID_INICIATIVA")
	@JsonIgnoreProperties(value = {"temas"}, allowSetters = true)
	private Iniciativa iniciativa;

	/**
	 * Instantiates a new temas.
	 */
	public Temas() {
	}

	/**
	 * Instantiates a new temas.
	 *
	 * @param idTema the id tema
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param iniciativa the iniciativa
	 */
	public Temas(Long idTema, String titulo, String descripcion, String inicio,
			String fin, Iniciativa iniciativa) {
		this.idTema = idTema;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.iniciativa = iniciativa;
	}

	/**
	 * Instantiates a new temas.
	 *
	 * @param idTema the id tema
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param iniciativa the iniciativa
	 */
	public Temas(Long idTema, String titulo, String descripcion, Iniciativa iniciativa) {
		this.idTema = idTema;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.iniciativa = iniciativa;
	}

	/**
	 * Instantiates a new temas.
	 *
	 * @param idTema the id tema
	 * @param titulo the titulo
	 * @param iniciativa the iniciativa
	 */
	public Temas(Long idTema, String titulo, Iniciativa iniciativa) {
		this.idTema = idTema;
		this.titulo = titulo;
		this.iniciativa = iniciativa;
	}
	
	

	/**
	 * Gets the id tema.
	 *
	 * @return the id tema
	 */
	public Long getIdTema() {
		return idTema;
	}

	/**
	 * Sets the id tema.
	 *
	 * @param idTema the new id tema
	 */
	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the inicio.
	 *
	 * @return the inicio
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * Sets the inicio.
	 *
	 * @param inicio the new inicio
	 */
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	/**
	 * Gets the fin.
	 *
	 * @return the fin
	 */
	public String getFin() {
		return fin;
	}

	/**
	 * Sets the fin.
	 *
	 * @param fin the new fin
	 */
	public void setFin(String fin) {
		this.fin = fin;
	}

	/**
	 * Gets the iniciativa.
	 *
	 * @return the iniciativa
	 */
	public Iniciativa getIniciativa() {
		return iniciativa;
	}

	/**
	 * Sets the iniciativa.
	 *
	 * @param iniciativa the new iniciativa
	 */
	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Temas [idTema=" + idTema + ", titulo=" + titulo + ", descripcion=" + descripcion + ", inicio=" + inicio
				+ ", fin=" + fin + ", iniciativa=" + iniciativa + "]";
	}
	
}
