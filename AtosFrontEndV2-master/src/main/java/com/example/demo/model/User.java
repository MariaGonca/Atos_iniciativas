package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rolee;
	
	@NotBlank
	@Size(max = 20)
	private String apellidos;

	@NotBlank
	@Size(max = 20)
	private String location;

	@NotBlank
	@Size(max = 20)
	private String teacher;

	@NotBlank
	@Size(max = 20)
	private String nameGroupTeams;

	@NotBlank
	@Size(max = 20)
	private String groupProyect;

	@NotBlank
	@Size(max = 20)
	private String center;

	@NotBlank
	@Size(max = 20)
	private String dni;

	@NotBlank
	@Size(max = 20)
	private String fechaNacimiento;

	@NotBlank
	@Size(max = 20)
	private String fechaFCT;

	@NotBlank
	@Size(max = 20)
	private String finFCT;

	@NotBlank
	@Size(max = 20)
	private String tipo;

	@NotBlank
	@Size(max = 20)
	private String ss;

	@NotBlank
	@Size(max = 20)
	private String rr;

	@NotBlank
	@Size(max = 20)
	private String ceco;

	@NotBlank
	@Size(max = 20)
	private String orgUnit;

	@NotBlank
	@Size(max = 20)
	private String sociedad;

	@NotBlank
	@Size(max = 20)
	private String phone;

	@NotBlank
	@Size(max = 20)
	private String emailAtos;

	@NotBlank
	@Size(max = 20)
	private String das;

	@NotBlank
	@Size(max = 20)
	private String convenio;

	@NotBlank
	@Size(max = 20)
	private String contacto;

	@NotBlank
	@Size(max = 20)
	private String positionId;

	@NotBlank
	@Size(max = 20)
	private String becas;

	@NotBlank
	@Size(max = 20)
	private String po;

	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String apellidos, String becas, String ceco,
			String contacto, String das, String emailAtos, String center, String dni, String convenio, String fechaFCT, String fechaNacimiento,
			String finFCT, String groupProyect, String location, String nameGroupTeams, String orgUnit, String phone, String po,
			String positionId, String rR, String sociedad, String ss, String teacher, String tipo, String password) {
		super();
		this.apellidos = apellidos;
		this.location = location;
		this.teacher = teacher;
		this.nameGroupTeams = nameGroupTeams;
		this.groupProyect = groupProyect;
		this.center = center;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFCT = fechaFCT;
		this.finFCT = finFCT;
		this.tipo = tipo;
		this.ss = ss;
		this.rr = rR;
		this.ceco = ceco;
		this.orgUnit = orgUnit;
		this.sociedad = sociedad;
		this.phone = phone;
		this.emailAtos = emailAtos;
		this.das = das;
		this.convenio = convenio;
		this.contacto = contacto;
		this.positionId = positionId;
		this.becas = becas;
		this.po = po;
		this.username = username;
		this.email = email;
	
		this.password = password;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getNameGroupTeams() {
		return nameGroupTeams;
	}

	public void setNameGroupTeams(String nameGroupTeams) {
		this.nameGroupTeams = nameGroupTeams;
	}

	public String getGroupProyect() {
		return groupProyect;
	}

	public void setGroupProyect(String groupProyect) {
		this.groupProyect = groupProyect;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaFCT() {
		return fechaFCT;
	}

	public void setFechaFCT(String fechaFCT) {
		this.fechaFCT = fechaFCT;
	}

	public String getFinFCT() {
		return finFCT;
	}

	public void setFinFCT(String finFCT) {
		this.finFCT = finFCT;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	

	public String getRr() {
		return rr;
	}

	public void setRr(String rr) {
		this.rr = rr;
	}

	public String getCeco() {
		return ceco;
	}

	public void setCeco(String ceco) {
		this.ceco = ceco;
	}

	public String getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}

	public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailAtos() {
		return emailAtos;
	}

	public void setEmailAtos(String emailAtos) {
		this.emailAtos = emailAtos;
	}

	public String getDas() {
		return das;
	}

	public void setDas(String das) {
		this.das = das;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getBecas() {
		return becas;
	}

	public void setBecas(String becas) {
		this.becas = becas;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

}