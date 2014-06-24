package org.iasd.iglesia.service;

import java.util.List;

import org.iasd.iglesia.web.form.UsuarioForm;

public interface UsuarioService {
	void guardarUsuario(UsuarioForm usuario);
	List<UsuarioForm> getListaUsuarios();
	boolean verificarAcceso(String username, String contrasenia);
}
