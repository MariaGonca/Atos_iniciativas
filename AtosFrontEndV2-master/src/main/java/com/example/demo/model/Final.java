package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "tutoriales")
	public class Final {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		@Column(name = "titulo")
		private String titulo;

		@Column(name = "descripcion")
		private String descripcion;

		@Column(name = "imagen")
		private String imagen;
		
		@Column(name = "publicado")
		private boolean publicado;

		public Final() {

		}
		
		public Final(String titulo, String descripcion, String imagen, boolean publicado) {
			this.titulo = titulo;
			this.descripcion = descripcion;
			this.publicado = publicado;
			this.imagen = imagen;
		}

		public long getId() {
			return id;
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

		public boolean esPublicado() {
			return publicado;
		}

		public void setPublicado(boolean esPublicado) {
			this.publicado = esPublicado;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		@Override
		public String toString() {
			return "Tutorial [id=" + id + ", titulo=" + titulo + ", desc=" + descripcion + ", imagen=" + imagen + ", publicado=" + publicado + "]";
		}

}

