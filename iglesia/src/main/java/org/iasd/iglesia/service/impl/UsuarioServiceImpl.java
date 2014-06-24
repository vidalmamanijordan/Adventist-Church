package org.iasd.iglesia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.iasd.iglesia.dao.UsuarioDAO;
import org.iasd.iglesia.dao.impl.UsuarioDAOJdbcImpl;
import org.iasd.iglesia.dominio.Usuario;
import org.iasd.iglesia.service.UsuarioService;
import org.iasd.iglesia.web.form.UsuarioForm;

public class UsuarioServiceImpl implements UsuarioService{
	
	UsuarioDAO usuarioDAO = new UsuarioDAOJdbcImpl();
	
	public void guardarUsuario(UsuarioForm usuario) {
		Usuario u = new Usuario();
		
		u.setCodigo(usuario.getCodigo());
		u.setUsername(usuario.getUsername());
		u.setPassword(usuario.getPassword());

		usuarioDAO.guardar(u);

	}
	public List<UsuarioForm> getListaUsuarios() {
		List<UsuarioForm> lista = new ArrayList<UsuarioForm>();

		return lista;
	}

	public boolean verificarAcceso(String username, String contrasenia) {
		Usuario u = usuarioDAO.getUsuarioPorUsernameYContrasenia(username, contrasenia);
		if(u!=null){
			return true;
		}
		return false;
	}
}
