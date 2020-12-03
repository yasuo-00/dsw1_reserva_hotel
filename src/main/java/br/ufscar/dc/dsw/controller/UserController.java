package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.error.Error;

@WebServlet(urlPatterns = {"/Admin/*"})
public class UserController extends HttpServlet{

	  private static final long serialVersionUID = 1L;

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	User user = (User) request.getSession().getAttribute("loggedUser");
	    	Error error = new Error();
	    	
	    	if (user == null) {
	    		response.sendRedirect(request.getContextPath());
	    		return;
	    	} else if (user.getBookingSiteURL()!=null || user.getHotelCNPJ()!=null) {
	    		error.add("Acesso não autorizado!");
				error.add("Apenas Papel [ADMIN] tem acesso a essa página");
				request.setAttribute("mensagens", error);
				RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
				rd.forward(request, response);
				return;
	    	}  	
	    }
}
