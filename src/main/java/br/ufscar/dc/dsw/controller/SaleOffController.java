package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.SaleOffDAO;
import br.ufscar.dc.dsw.error.Error;

@WebServlet(urlPatterns = {"/SaleOff"})
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
		User user = (User) req.getSession().getAttribute("userLogado");
		Error error = new Error();

		if (user == null) {
			res.sendRedirect(req.getContextPath());
			return;
		} else if (user.getHotelCNPJ() != null && user.getBookingSiteURL() != null) {
			error.add("Acesso não autorizado!");
			error.add("Apenas Papel [ADMIN] tem acesso a essa página");
			req.setAttribute("mensagens", error);
			RequestDispatcher rd = req.getRequestDispatcher("/noAuth.jsp");
			rd.forward(req, res);
			return;
		}

		String action = req.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/register":
				showRegisterForm(req, res);
				break;
			case "/insert":
				insert(req, res);
				break;
			case "/remove":
				remove(req, res);
				break;
			case "/edit":
				showEditForm(req, res);
				break;
			case "/update":
				update(req, res);
				break;
			default:
				listAll(req, res);
				break;
			}
		} catch (RuntimeException | IOException | ServletException | ParseException e) {
			throw new ServletException(e);
		}
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
	
	private void showRegisterForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/bookingSite/form.jsp");
		dispatcher.forward(req, res);
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException {
		String cnpj = req.getParameter("hotelCNPJ");
		String url = req.getParameter("bookingSiteURL");
		Date initialDate = dateFormatter.parse(req.getParameter("initialDate"));
		Date finalDate = dateFormatter.parse(req.getParameter("finalDate"));
		SaleOff saleOff = dao.getSaleOff(cnpj,url, initialDate, finalDate);
		req.setAttribute("saleOff", saleOff);
		//arrumar essa rota
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/saleOff/form.jsp");
		dispatcher.forward(req, res);
	}
}
