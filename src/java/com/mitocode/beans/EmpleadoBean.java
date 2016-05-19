package com.mitocode.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mitocode.dao.EmpleadoDAO;
import com.mitocode.model.Empleado;

@ManagedBean
@SessionScoped
public class EmpleadoBean {

	private Empleado empleado = new Empleado();
	private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	private List<Empleado> lstEmpleados;

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	public void registrar() throws Exception {
		empleadoDAO.Registrar(this.empleado);
	}

	public void eliminar(Empleado emp) throws Exception {
		empleadoDAO.Eliminar(emp);
		this.listar();
	}

	public String leer(Empleado emp) {
		this.empleado = emp;
		return "editar";
	}

	/*
	 * Luego de cargar los datos del objeto con el metodo leer, puedo modificar
	 * con nuevos datos
	 */
	public String modificar() throws Exception {
		empleadoDAO.Modificar(this.empleado);
		return "exito";
	}

	public void listar() throws Exception {
		this.lstEmpleados = empleadoDAO.Listar();
	}

}
