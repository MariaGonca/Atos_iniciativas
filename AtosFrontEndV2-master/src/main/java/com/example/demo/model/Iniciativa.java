package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="iniciativas")
public class Iniciativa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_INICIATIVA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIniciativa;
	
	@Column(name = "TITULO", unique=true)
	@NotNull
	@NotEmpty
	private String titulo;
	
	@Column(name = "DESCRIPCION")
	@NotNull
	@NotEmpty
	private String descripcion;
	
	@Column(name = "INICIO")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@NotEmpty
	@Pattern(regexp="[0-9]{2}-[0-9]{2}-[0-9]{4}")
	private String inicio;
	
	@Column(name = "FIN")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@NotEmpty
	@Pattern(regexp="[0-9]{2}-[0-9]{2}-[0-9]{4}")
	private String fin;
	
	@Column(name="ACTIVA")
	@ColumnDefault("true")
	private Boolean activa = true;
	
	@OneToMany(mappedBy = "iniciativa")
	private List<Temas> temas = new ArrayList<>();

	
	
	public List<Temas> getTemas() {
		return temas;
	}

	public void setTemas(List<Temas> temas) {
		this.temas = temas;
	}

	public Long getIdIniciativa() {
		return idIniciativa;
	}

	public void setIdIniciativa(Long idIniciativa) {
		this.idIniciativa = idIniciativa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	public Iniciativa(Long idIniciativa, String titulo, String descripcion, String inicio, String fin, Boolean activa) {
		this.idIniciativa = idIniciativa;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.activa = activa;
	}

	public Iniciativa(Long idIniciativa, String titulo, String descripcion, String inicio, String fin, Boolean activa, List<Temas> temas) {
		this.idIniciativa = idIniciativa;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.activa = activa;
		this.temas = temas;
	}

	public Iniciativa() {	
	}

	@Override
	public String toString() {
		return "Iniciativa [idIniciativa=" + idIniciativa + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", inicio=" + inicio + ", fin=" + fin + ", activa=" + activa + "]";
	}
	
}
