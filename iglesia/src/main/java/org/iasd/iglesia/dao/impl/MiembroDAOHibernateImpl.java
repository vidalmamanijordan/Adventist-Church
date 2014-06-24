package org.iasd.iglesia.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.iasd.iglesia.dao.MiembroDAO;
import org.iasd.iglesia.dominio.Miembro;
import org.iasd.iglesia.util.HibernateUtil;

public class MiembroDAOHibernateImpl implements MiembroDAO{
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private Session session = null;
	
	public void insertar(Miembro m){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Miembro> listar(){
		session = sessionFactory.openSession();
		List<Miembro> lista = session.createCriteria(Miembro.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();
		return lista;
	}
	
	public Miembro getMiembroPorId(String id){
		session = sessionFactory.openSession();
		Miembro m = (Miembro)session.createCriteria(Miembro.class)
				.add(Restrictions.idEq(new Long(id))).uniqueResult();
		session.close();
		return m;
	}
	
	public void actualizar(Miembro miembro){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(miembro);
		session.getTransaction().commit();
		session.close();
	}
}
