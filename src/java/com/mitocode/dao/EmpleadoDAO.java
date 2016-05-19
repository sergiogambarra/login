package com.mitocode.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.mitocode.model.Empleado;
import com.mitocode.util.HibernateUtil;

public class EmpleadoDAO {

	private Session session;
	private Transaction trans;
	private List<Empleado> lstEmpleados;

	public void Registrar(Empleado emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Eliminar(Empleado emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Modificar(Empleado emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(emp);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public List<Empleado> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Empleado.class);
			cri.addOrder(Order.asc("apellidos"));
			lstEmpleados = cri.list();
		} catch (Exception ex) {
			throw ex;
		}
		return lstEmpleados;
	}
}
