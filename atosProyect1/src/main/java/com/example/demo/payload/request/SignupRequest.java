package com.example.demo.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SignupRequest.
 */
public class SignupRequest {

	/** The username. */
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	/** The email. */
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	/** The role. */
	private Set<String> role;

	/** The password. */
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

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

	/** The i. */
	private String i;

	/**
	 * Gets the i.
	 *
	 * @return the i
	 */
	public String getI() {
		return i;
	}

	/**
	 * Sets the i.
	 *
	 * @param i the new i
	 */
	public void setI(String i) {
		this.i = i;
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
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Set<String> getRole() {
		return this.role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Set<String> role) {
		this.role = role;
	}
}
