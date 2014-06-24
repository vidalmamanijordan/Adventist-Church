package org.iasd.iglesia.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iasd.iglesia.service.MiembroService;
import org.iasd.iglesia.service.impl.MiembroServiceImpl;
import org.iasd.iglesia.web.form.MiembroForm;

public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String VIEW_HOME = "/pages/home.jsp";
	
	MiembroService miembroService = new MiembroServiceImpl();
	
	public HomeServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<MiembroForm> lista = miembroService.listar();
		for(MiembroForm miembroForm : lista){
			System.out.println(miembroForm.getNombre());
		}
		request.setAttribute("lp", lista);
		
		request.getRequestDispatcher(VIEW_HOME).forward(request, response);
	}
}

