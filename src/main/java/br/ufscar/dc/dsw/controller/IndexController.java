package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.UserDAO;
import br.ufscar.dc.dsw.error.Error;

@WebServlet(name = "Index", urlPatterns = { "/index.jsp", "/logout.jsp" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Error errors = new Error();
		if (request.getParameter("bOK") != null) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			if (email == null || email.isEmpty()) {
				errors.add("Email não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				errors.add("Password não informada!");
			}
			if (!errors.isThereError()) {
				UserDAO dao = new UserDAO();
				User user = dao.getByEmail(email);
				if (user != null) {
					if (user.getPassword().equalsIgnoreCase(senha)) {
						request.getSession().setAttribute("userLogado", user);
						if (user.getBookingSiteURL() == null && user.getHotelCNPJ() == null) {
							response.sendRedirect("admin/");
						} else if (user.getBookingSiteURL() == null && user.getHotelCNPJ() != null) {
							response.sendRedirect("hotel/");
						} else if (user.getBookingSiteURL() != null && user.getHotelCNPJ() == null) {
							response.sendRedirect("bookingSite/");
						}
						return;
					} else {
						errors.add("Password inválida!");
					}
				} else {
					errors.add("Usuário não encontrado!");
				}
			}
		}
		request.getSession().invalidate();

		request.setAttribute("messages", errors);

		String URL = "/email.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
