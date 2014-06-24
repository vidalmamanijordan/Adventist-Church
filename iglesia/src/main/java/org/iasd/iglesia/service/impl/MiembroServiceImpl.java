package org.iasd.iglesia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.iasd.iglesia.dao.MiembroDAO;
import org.iasd.iglesia.dao.impl.MiembroDAOHibernateImpl;
import org.iasd.iglesia.dominio.Miembro;
import org.iasd.iglesia.service.MiembroService;
import org.iasd.iglesia.web.form.MiembroForm;



public class MiembroServiceImpl implements MiembroService{
	
	MiembroDAO miembroDAO = new MiembroDAOHibernateImpl();
	
	public List<MiembroForm> listar(){
		
		List<MiembroForm> l = new ArrayList<MiembroForm>();

		List<Miembro> lista = miembroDAO.listar();
		System.out.println("Lista devuelta :" + lista.size());

		for (Miembro p : lista) {
			MiembroForm pf = new MiembroForm();
			pf.setId(p.getId()+"");//Convertimos a Cadena...
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}
		return l;
	}
	
	public void guardar(MiembroForm m){
		Miembro miembro = new Miembro();
		
		miembro.setApePat(m.getApePat());
		miembro.setApeMat(m.getApeMat());
		miembro.setNombre(m.getNombre());
		
		if (StringUtils.isEmpty(m.getId())) {
			miembroDAO.insertar(miembro);
		} else {
			miembro.setId(new Long(m.getId()));
			miembroDAO.actualizar(miembro);
		}
	}
	
	public MiembroForm getMiembroPorId(String id){
		
		MiembroForm m = new MiembroForm();
		Miembro miembro = miembroDAO.getMiembroPorId(id);
		
		if(miembro !=null){
			m.setId(miembro.getId()+"");
			m.setNombre(miembro.getNombre());
			m.setApePat(miembro.getApePat());
			m.setApeMat(miembro.getApeMat());
		}
		
		return m;
	}
}
