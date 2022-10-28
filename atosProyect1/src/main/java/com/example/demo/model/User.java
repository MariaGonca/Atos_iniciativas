package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email") })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The rolee. */
	private String rolee;
	
	/** The apellidos. */
	@NotBlank
	@Size(max = 20)
	private String apellidos;

	/** The location. */
	@NotBlank
	@Size(max = 20)
	private String location;

	/** The teacher. */
	@Size(max = 20)
	private String teacher;

	/** The name group teams. */
	@Size(max = 20)
	private String nameGroupTeams;

	/** The group proyect. */
	@Size(max = 20)
	private String groupProyect;
	
	/** The center. */
	@NotBlank
	@Size(max = 20)
	private String center;

	/** The dni. */
	@Size(max = 20)
	private String dni;

	/** The fecha nacimiento. */
	@Size(max = 20)
	private String fechaNacimiento;


	/** The fecha FCT. */
	@Size(max = 20)
	private String fechaFCT;

	
	/** The fin FCT. */
	@Size(max = 20)
	private String finFCT;


	/** The tipo. */
	@Size(max = 20)
	private String tipo;

	
	/** The ss. */
	@Size(max = 20)
	private String ss;


	/** The rr. */
	@Size(max = 20)
	private String rr;

	
	/** The ceco. */
	@Size(max = 20)
	private String ceco;


	/** The org unit. */
	@Size(max = 20)
	private String orgUnit;

	
	/** The sociedad. */
	@Size(max = 20)
	private String sociedad;

	
	/** The phone. */
	@Size(max = 20)
	private String phone;

	
	/** The email atos. */
	@Size(max = 20)
	private String emailAtos;
	
	/** The das. */
	@NotBlank
	@Size(max = 20)
	private String das;

	/** The convenio. */
	@Size(max = 20)
	private String convenio;

	
	/** The contacto. */
	@Size(max = 20)
	private String contacto;

	
	/** The position id. */
	@Size(max = 20)
	private String positionId;

	
	/** The becas. */
	@Size(max = 20)
	private String becas;

	
	/** The po. */
	@Size(max = 20)
	private String po;

	/** The username. */
	@NotBlank
	@Size(max = 20)
	private String username;
	
	/** The email. */
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	/** The password. */
	@Size(max = 120)
	private String password;
	
	/** The roles. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/** The iniciativa user. */
	@OneToOne(fetch = FetchType.LAZY)
	@NotNull
	@ElementCollection
	@JoinColumn(name = "ID_INICIATIVA")
	@JsonIgnoreProperties(value = {"users"}, allowSetters = true)
	private Iniciativa iniciativaUser;
	
    /** The u. */
    private String u;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param email the email
	 * @param apellidos the apellidos
	 * @param becas the becas
	 * @param ceco the ceco
	 * @param contacto the contacto
	 * @param das the das
	 * @param emailAtos the email atos
	 * @param center the center
	 * @param dni the dni
	 * @param convenio the convenio
	 * @param fechaFCT the fecha FCT
	 * @param fechaNacimiento the fecha nacimiento
	 * @param finFCT the fin FCT
	 * @param groupProyect the group proyect
	 * @param location the location
	 * @param nameGroupTeams the name group teams
	 * @param orgUnit the org unit
	 * @param phone the phone
	 * @param po the po
	 * @param positionId the position id
	 * @param rR the r R
	 * @param sociedad the sociedad
	 * @param ss the ss
	 * @param teacher the teacher
	 * @param tipo the tipo
	 * @param u the u
	 * @param password the password
	 * @param iniciativaUser the iniciativa user
	 */
	public User(String username, String email, String apellidos, String becas, String ceco,
			String contacto, String das, String emailAtos, String center, String dni, String convenio, String fechaFCT, String fechaNacimiento,
			String finFCT, String groupProyect, String location, String nameGroupTeams, String orgUnit, String phone, String po,
			String positionId, String rR, String sociedad, String ss, String teacher, String tipo, String u , String password, Iniciativa iniciativaUser ) {
		super();
		this.iniciativaUser = iniciativaUser;
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
	    this.u=u;
		this.password = password;

	}
	
	

    /**
     * Gets the iniciativa user.
     *
     * @return the iniciativa user
     */
    public Iniciativa getIniciativaUser() {
		return iniciativaUser;
	}

	/**
	 * Sets the iniciativa user.
	 *
	 * @param iniciativaUser the new iniciativa user
	 */
	public void setIniciativaUser(Iniciativa iniciativaUser) {
		this.iniciativaUser = iniciativaUser;
	}
	
	/**
	 * Gets the u.
	 *
	 * @return the u
	 */
	public String getU() {
		return u;
	}

	/**
	 * Sets the u.
	 *
	 * @param u the new u
	 */
	public void setU(String u) {
		this.u = u;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the teacher.
	 *
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * Sets the teacher.
	 *
	 * @param teacher the new teacher
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * Gets the name group teams.
	 *
	 * @return the name group teams
	 */
	public String getNameGroupTeams() {
		return nameGroupTeams;
	}

	/**
	 * Sets the name group teams.
	 *
	 * @param nameGroupTeams the new name group teams
	 */
	public void setNameGroupTeams(String nameGroupTeams) {
		this.nameGroupTeams = nameGroupTeams;
	}

	/**
	 * Gets the group proyect.
	 *
	 * @return the group proyect
	 */
	public String getGroupProyect() {
		return groupProyect;
	}

	/**
	 * Sets the group proyect.
	 *
	 * @param groupProyect the new group proyect
	 */
	public void setGroupProyect(String groupProyect) {
		this.groupProyect = groupProyect;
	}

	/**
	 * Gets the center.
	 *
	 * @return the center
	 */
	public String getCenter() {
		return center;
	}

	/**
	 * Sets the center.
	 *
	 * @param center the new center
	 */
	public void setCenter(String center) {
		this.center = center;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Gets the fecha FCT.
	 *
	 * @return the fecha FCT
	 */
	public String getFechaFCT() {
		return fechaFCT;
	}

	/**
	 * Sets the fecha FCT.
	 *
	 * @param fechaFCT the new fecha FCT
	 */
	public void setFechaFCT(String fechaFCT) {
		this.fechaFCT = fechaFCT;
	}

	/**
	 * Gets the fin FCT.
	 *
	 * @return the fin FCT
	 */
	public String getFinFCT() {
		return finFCT;
	}

	/**
	 * Sets the fin FCT.
	 *
	 * @param finFCT the new fin FCT
	 */
	public void setFinFCT(String finFCT) {
		this.finFCT = finFCT;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the ss.
	 *
	 * @return the ss
	 */
	public String getSs() {
		return ss;
	}

	/**
	 * Sets the ss.
	 *
	 * @param ss the new ss
	 */
	public void setSs(String ss) {
		this.ss = ss;
	}

	

	/**
	 * Gets the rr.
	 *
	 * @return the rr
	 */
	public String getRr() {
		return rr;
	}

	/**
	 * Sets the rr.
	 *
	 * @param rr the new rr
	 */
	public void setRr(String rr) {
		this.rr = rr;
	}

	/**
	 * Gets the ceco.
	 *
	 * @return the ceco
	 */
	public String getCeco() {
		return ceco;
	}

	/**
	 * Sets the ceco.
	 *
	 * @param ceco the new ceco
	 */
	public void setCeco(String ceco) {
		this.ceco = ceco;
	}

	/**
	 * Gets the org unit.
	 *
	 * @return the org unit
	 */
	public String getOrgUnit() {
		return orgUnit;
	}

	/**
	 * Sets the org unit.
	 *
	 * @param orgUnit the new org unit
	 */
	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}

	/**
	 * Gets the sociedad.
	 *
	 * @return the sociedad
	 */
	public String getSociedad() {
		return sociedad;
	}

	/**
	 * Sets the sociedad.
	 *
	 * @param sociedad the new sociedad
	 */
	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the email atos.
	 *
	 * @return the email atos
	 */
	public String getEmailAtos() {
		return emailAtos;
	}

	/**
	 * Sets the email atos.
	 *
	 * @param emailAtos the new email atos
	 */
	public void setEmailAtos(String emailAtos) {
		this.emailAtos = emailAtos;
	}

	/**
	 * Gets the das.
	 *
	 * @return the das
	 */
	public String getDas() {
		return das;
	}

	/**
	 * Sets the das.
	 *
	 * @param das the new das
	 */
	public void setDas(String das) {
		this.das = das;
	}

	/**
	 * Gets the convenio.
	 *
	 * @return the convenio
	 */
	public String getConvenio() {
		return convenio;
	}

	/**
	 * Sets the convenio.
	 *
	 * @param convenio the new convenio
	 */
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	/**
	 * Gets the contacto.
	 *
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * Sets the contacto.
	 *
	 * @param contacto the new contacto
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * Gets the position id.
	 *
	 * @return the position id
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * Sets the position id.
	 *
	 * @param positionId the new position id
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * Gets the becas.
	 *
	 * @return the becas
	 */
	public String getBecas() {
		return becas;
	}

	/**
	 * Sets the becas.
	 *
	 * @param becas the new becas
	 */
	public void setBecas(String becas) {
		this.becas = becas;
	}

	/**
	 * Gets the po.
	 *
	 * @return the po
	 */
	public String getPo() {
		return po;
	}

	/**
	 * Sets the po.
	 *
	 * @param po the new po
	 */
	public void setPo(String po) {
		this.po = po;
	}

}