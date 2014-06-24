package org.iasd.iglesia.service;

import java.util.List;

import org.iasd.iglesia.web.form.MiembroForm;

public interface MiembroService {
	List<MiembroForm> listar();
	void guardar(MiembroForm m);
	MiembroForm getMiembroPorId(String id);
}
