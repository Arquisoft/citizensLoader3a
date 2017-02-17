package es.uniovi.asw.model;

public class Association {

	public static class Asignar {

		public static void link(Usuario usuario, Ciudadano ciudadano) {
			usuario._setCiudadano(ciudadano);
			ciudadano._setUsuario(usuario);
		}

		public static void unlink(Usuario usuario, Ciudadano ciudadano) {
			ciudadano._setUsuario(null);
			usuario._setCiudadano(null);
		}
	}
}