package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.dao.BookingSiteDAO;

public class BookingSiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookingSiteDAO dao;

	@Override
	public void init() {
		dao = new BookingSiteDAO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		BookingSite bookingSite = new BookingSite(url, name, phone, password, email);

		dao.insert(bookingSite);
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		BookingSite bookingSite = new BookingSite(url, name, phone, password, email);

		dao.update(bookingSite);
		response.sendRedirect("list");
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = request.getParameter("url");

		BookingSite bookingSite = new BookingSite(url);
		dao.remove(bookingSite);
		response.sendRedirect("list");
	}

	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BookingSite> bookingSiteList = dao.listAll();

		request.setAttribute("bookingSiteList", bookingSiteList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
}
