package org.iasd.iglesia.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iasd.iglesia.service.UsuarioService;
import org.iasd.iglesia.service.impl.UsuarioServiceImpl;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_HOME = "/pages/web/home.jsp";
	private static final String VIEW_ERROR_LOGIN = "/pages/web/error_login.jsp";
	
	UsuarioService usuarioService = new UsuarioServiceImpl();
	
    public LoginServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {

			if (usuarioService.verificarAcceso(username, password)) {
				request.getRequestDispatcher(VIEW_HOME).forward(request,
						response);
			} else {
				request.getRequestDispatcher(VIEW_ERROR_LOGIN).forward(request,
						response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
