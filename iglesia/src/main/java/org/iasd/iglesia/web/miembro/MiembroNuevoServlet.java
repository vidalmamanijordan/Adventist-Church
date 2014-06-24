package org.iasd.iglesia.web.miembro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iasd.iglesia.service.MiembroService;
import org.iasd.iglesia.service.impl.MiembroServiceImpl;
import org.iasd.iglesia.web.form.MiembroForm;

public class MiembroNuevoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/miembro/main.jsp";
	private static final String VIEW_FORMULARIO = "/pages/miembro/formulario.jsp";

	MiembroService miembroService = new MiembroServiceImpl();

	public MiembroNuevoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_FORMULARIO)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");

		MiembroForm miembroForm = new MiembroForm();
		miembroForm.setNombre(nombre);
		miembroForm.setApePat(paterno);
		miembroForm.setApeMat(materno);

		miembroService.guardar(miembroForm);

		List<MiembroForm> lista = miembroService.listar();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}
}