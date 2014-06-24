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

public class MiembroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/miembro/main.jsp";
	
	MiembroService miembroService = new MiembroServiceImpl();
	
    public MiembroServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		List<MiembroForm> lista= miembroService.listar();
		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}