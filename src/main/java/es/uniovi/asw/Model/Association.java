package es.uniovi.asw.Model;

public class Association {
	public static class AsignarUsuario{
		public static void link(Usuario usuario, Ciudadano ciudadano){
			usuario._setCiudadano(ciudadano);
			ciudadano._setUsuario(usuario);
		}
		
		public static void unLink(Usuario usuario, Ciudadano ciudadano){
			ciudadano._setUsuario(null);
			usuario._setCiudadano(null);
		}
	}
}
