package es.uniovi.asw.Model;

public class Usuario {
	private String usuario;
	private String contraseña;
	private Ciudadano ciudadano;
	
	Usuario() {};
	
	public Usuario(String usuario, String contraseña, Ciudadano ciudadano) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.ciudadano = ciudadano;
		Association.AsignarUsuario.link(this, ciudadano);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	void _setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contraseña=" + contraseña + ", ciudadano=" + ciudadano + "]";
	}
	
	public void desasignar(){
		Association.AsignarUsuario.unLink(this, ciudadano);
	}
}
