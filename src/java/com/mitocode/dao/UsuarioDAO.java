package com.mitocode.dao;

// default package
// Generated 24/01/2014 09:58:50 PM by Hibernate Tools 3.4.0.CR1


import org.hibernate.Query;
import org.hibernate.Session;

import com.mitocode.model.Usuario;
import com.mitocode.util.HibernateUtil;

import org.hibernate.Transaction;

public class UsuarioDAO {

	private Session session;
        private Transaction trans;
	

	public Usuario verificarDatos(Usuario usuario) throws Exception {
		Usuario us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre()
					+ "' and clave = '" + usuario.getClave() + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Usuario) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return us;
	}
        public void Registrar(Usuario usr) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(usr);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
}
