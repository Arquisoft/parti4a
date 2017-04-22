package es.uniovi.asw.dto;

import java.util.Date;

public class CitizenDTO {

	private String nombre;
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String direccionPostal;
	private String nacionalidad;
	private String numeroIdentificativo;

	public CitizenDTO(String nombre, String apellidos, String email, Date fechaNacimiento, String direccionPostal,
			String nacionalidad, String numeroIdentificativo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionPostal = direccionPostal;
		this.nacionalidad = nacionalidad;
		this.numeroIdentificativo = numeroIdentificativo;
	}

	public CitizenDTO() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNumeroIdentificativo() {
		return numeroIdentificativo;
	}

	public void setNumeroIdentificativo(String numeroIdentificativo) {
		this.numeroIdentificativo = numeroIdentificativo;
	}

}
