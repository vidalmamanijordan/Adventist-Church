package org.iasd.iglesia.dao;

import java.util.List;

import org.iasd.iglesia.dominio.Miembro;

public interface MiembroDAO {
	
	void insertar(Miembro m);
	
	List<Miembro> listar();
	
	Miembro getMiembroPorId(String id);
	
	void actualizar(Miembro miembro);
	
}
