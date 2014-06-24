package org.iasd.iglesia.dao;

import java.util.List;

import org.iasd.iglesia.dominio.Usuario;

public interface UsuarioDAO {
	
	void guardar(Usuario usuario);
	
	List<Usuario> listar();
	
	Usuario getUsuarioPorUsername(String username);
	
	Usuario getUsuarioPorUsernameYContrasenia(String username,String contrasenia);
}
