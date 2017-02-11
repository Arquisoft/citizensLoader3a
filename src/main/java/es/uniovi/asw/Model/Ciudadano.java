package es.uniovi.asw.Model;

import java.util.Date;

public class Ciudadano {
	private String nombre;
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String residencia;
	private String nacionalidad;
	private String dni;
	private Usuario usuario;
	
	Ciudadano() {};
	
	public Ciudadano(String nombre, String apellidos, String email, Date fechaNacimiento, String residencia,
			String nacionalidad, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudadano other = (Ciudadano) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getResidencia() {
		return residencia;
	}


	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public String getDni() {
		return dni;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	void _setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Ciudadano [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", residencia=" + residencia + ", nacionalidad=" + nacionalidad + ", dni=" + dni
				+ "]";
	}
}
