package org.iasd.iglesia.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IngresarServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_LOGIN = "/pages/web/login.jsp";
	
	//UsuarioService usuarioService = new UsuarioServiceImpl();
	
    public IngresarServelt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
