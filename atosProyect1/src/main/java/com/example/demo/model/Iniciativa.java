package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class Iniciativa.
 */
@Entity
@Table(name="iniciativas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Iniciativa implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id iniciativa. */
	@Id
	@Column(name = "ID_INICIATIVA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat(pattern = "idIniciativa")
	private Long idIniciativa;
	
	/** The titulo iniciativa. */
	@Column(name = "TITULO", unique=true)
	@NotNull
	@JsonFormat(pattern = "tituloIniciativa")
	@NotEmpty
	private String tituloIniciativa;
	
	/** The descripcion. */
	@Column(name = "DESCRIPCION")
	@JsonFormat(pattern = "descripcion")
	@NotNull
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
	
	/** The activa. */
	@Column(name="ACTIVA")
	@JsonFormat(pattern = "activa")
	@ColumnDefault("true")
	private Boolean activa = true;
	
	/** The temas. */
	@OneToMany(mappedBy = "iniciativa", cascade = CascadeType.ALL)
	@Nullable
	@JsonIgnoreProperties(value = {"iniciativa"}, allowSetters = true)
	private List<Temas> temas = new ArrayList<>();

	/** The user. */
	@OneToMany(mappedBy = "iniciativaUser", cascade = CascadeType.ALL)
	@Nullable
	@JsonIgnoreProperties(value = {"iniciativaUser"}, allowSetters = true)
	private List<User> user = new ArrayList<>();

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public List<User> getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}

	/**
	 * Gets the temas.
	 *
	 * @return the temas
	 */
	public List<Temas> getTemas() {
		return temas;
	}

	/**
	 * Sets the temas.
	 *
	 * @param temas the new temas
	 */
	public void setTemas(List<Temas> temas) {
		this.temas = temas;
	}

	/**
	 * Gets the id iniciativa.
	 *
	 * @return the id iniciativa
	 */
	public Long getIdIniciativa() {
		return idIniciativa;
	}

	/**
	 * Sets the id iniciativa.
	 *
	 * @param idIniciativa the new id iniciativa
	 */
	public void setIdIniciativa(Long idIniciativa) {
		this.idIniciativa = idIniciativa;
	}

	/**
	 * Gets the titulo iniciativa.
	 *
	 * @return the titulo iniciativa
	 */
	public String getTituloIniciativa() {
		return tituloIniciativa;
	}

	/**
	 * Sets the titulo iniciativa.
	 *
	 * @param tituloIniciativa the new titulo iniciativa
	 */
	public void setTituloIniciativa(String tituloIniciativa) {
		this.tituloIniciativa = tituloIniciativa;
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
	 * Gets the activa.
	 *
	 * @return the activa
	 */
	public Boolean getActiva() {
		return activa;
	}

	/**
	 * Sets the activa.
	 *
	 * @param activa the new activa
	 */
	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	/**
	 * Instantiates a new iniciativa.
	 *
	 * @param idIniciativa the id iniciativa
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param activa the activa
	 */
	public Iniciativa(Long idIniciativa, String tituloIniciativa, String descripcion, String inicio, String fin, Boolean activa) {
		this.idIniciativa = idIniciativa;
		this.tituloIniciativa = tituloIniciativa;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.activa = activa;
	}

	/**
	 * Instantiates a new iniciativa.
	 *
	 * @param idIniciativa the id iniciativa
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param activa the activa
	 * @param temas the temas
	 */
	public Iniciativa(Long idIniciativa, String tituloIniciativa, String descripcion, String inicio, String fin, Boolean activa, List<Temas> temas) {
		this.idIniciativa = idIniciativa;
		this.tituloIniciativa = tituloIniciativa;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.activa = activa;
		this.temas = temas;
	}

	
	
	/**
	 * Instantiates a new iniciativa.
	 *
	 * @param idIniciativa the id iniciativa
	 * @param tituloIniciativa the titulo iniciativa
	 * @param descripcion the descripcion
	 * @param inicio the inicio
	 * @param fin the fin
	 * @param activa the activa
	 * @param temas the temas
	 * @param user the user
	 */
	public Iniciativa(Long idIniciativa, String tituloIniciativa,
			 String descripcion, String inicio, String fin, Boolean activa, List<Temas> temas,
			List<User> user) {
		super();
		this.idIniciativa = idIniciativa;
		this.tituloIniciativa = tituloIniciativa;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.activa = activa;
		this.temas = temas;
		this.user = user;
	}

	/**
	 * Instantiates a new iniciativa.
	 */
	public Iniciativa() {	
	}
	
	
	
	

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Iniciativa [idIniciativa=" + idIniciativa + ", tituloIniciativa=" + tituloIniciativa + ", descripcion=" + descripcion
				+ ", inicio=" + inicio + ", fin=" + fin + ", activa=" + activa + "]";
	}
	
}
