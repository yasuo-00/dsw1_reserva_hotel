package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.dao.HotelDAO;

//@WebServlet(urlPatterns = {"/CRUDHotel"})
public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HotelDAO dao;

	@Override
	public void init() {
		dao = new HotelDAO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cnpj = request.getParameter("cnpj");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		double dailyRate = Double.parseDouble(request.getParameter("dailyRate"));
		String city = request.getParameter("city");

		Hotel hotel = new Hotel(cnpj, name, phone, city, email, password, dailyRate);

		dao.insert(hotel);
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cnpj = request.getParameter("cnpj");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		double dailyRate = Double.parseDouble(request.getParameter("dailyRate"));
		String city = request.getParameter("city");

		Hotel hotel = new Hotel(cnpj, name, phone, city, email, password, dailyRate);

		dao.update(hotel);
		response.sendRedirect("list");
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnpj = request.getParameter("cnpj");

		Hotel hotel = new Hotel(cnpj);
		dao.remove(hotel);
		response.sendRedirect("list");
	}

	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Hotel> hotelList = dao.listAll();

		request.setAttribute("hotelList", hotelList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
}
