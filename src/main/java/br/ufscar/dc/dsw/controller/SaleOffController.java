package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.dao.SaleOffDAO;

public class SaleOffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SaleOffDAO dao;
	private SimpleDateFormat dateFormatter;

	@Override
	public void init() {
		dao = new SaleOffDAO();
		dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		request.setCharacterEncoding("UTF-8");

		String hotelCNPJ = request.getParameter("hotelCNPJ");
		String bookingSiteURL = request.getParameter("bookingSiteURL");
		Date initialDate = dateFormatter.parse(request.getParameter("initialDate"));
		Date finalDate = dateFormatter.parse(request.getParameter("finalDate"));
		double discount = Double.parseDouble(request.getParameter("discount"));

		SaleOff saleOff = new SaleOff(hotelCNPJ, bookingSiteURL, initialDate, finalDate, discount);

		dao.insert(saleOff);
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

		String hotelCNPJ = request.getParameter("hotelCNPJ");
		String bookingSiteURL = request.getParameter("bookingSiteURL");
		Date initialDate = dateFormatter.parse(request.getParameter("initialDate"));
		Date finalDate = dateFormatter.parse(request.getParameter("finalDate"));
		double discount = Double.parseDouble(request.getParameter("discount"));

		SaleOff saleOff = new SaleOff(hotelCNPJ, bookingSiteURL, initialDate, finalDate, discount);

		dao.update(saleOff);
		response.sendRedirect("list");
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String hotelCNPJ = request.getParameter("hotelCNPJ");
		String bookingSiteURL = request.getParameter("bookingSiteURL");
		Date initialDate = dateFormatter.parse(request.getParameter("initialDate"));
		Date finalDate = dateFormatter.parse(request.getParameter("finalDate"));

		SaleOff saleOff = new SaleOff(hotelCNPJ, bookingSiteURL, initialDate, finalDate);

		dao.remove(saleOff);
		response.sendRedirect("list");
	}

	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SaleOff> saleOffList = dao.listAll();

		request.setAttribute("saleOffList", saleOffList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
}
