package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;
import com.mitocode.dao.UsuarioDAO;
import com.mitocode.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
        private UsuarioDAO usuarioDAO = new UsuarioDAO();
        

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String verificarDatos() throws Exception {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario us;
		String resultado;

		try {
			// Enviando la encriptacion
			//String encript = DigestUtils.md5Hex(this.usuario.getNombre());
                        String encript = DigestUtils.shaHex(this.usuario.getClave());
			//String encript = DigestUtils.sha1Hex(this.usuario.getClave());
			this.usuario.setClave(encript);

			us = usuDAO.verificarDatos(this.usuario);
			if (us != null) {

				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("usuario", us);

				resultado = "exito"; // recalcar que el faces-redirect=true,
										// olvida la peticion anterior y se
										// dirige a la vista
			} else {
				resultado = "error";
			}
		} catch (Exception e) {
			throw e;
		}

		return resultado;
	}

	public boolean verificarSesion() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}

		return estado;
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "index";
	}
        
        public void registrar() throws Exception {
                UsuarioDAO usuDAO = new UsuarioDAO();
                
                // Enviando la encriptacion
			//String encript = DigestUtils.md5Hex(this.usuario.getNombre());
                        String encript = DigestUtils.shaHex(this.usuario.getClave());
			//String encript = DigestUtils.sha1Hex(this.usuario.getClave());
			this.usuario.setClave(encript);
		                
                usuDAO.Registrar(this.usuario);
            
	}
}
