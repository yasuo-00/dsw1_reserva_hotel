package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.UserDAO;
import br.ufscar.dc.dsw.error.Error;

@WebServlet(urlPatterns = {"/Hotels/*"})
public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HotelDAO dao;
	private UserDAO uDAO;

	@Override
	public void init() {
		dao = new HotelDAO();
		uDAO = new UserDAO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String action = req.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/listByCity":
				listByCity(req,res);
			default:
				listAll(req, res);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		User user = (User) req.getSession().getAttribute("loggedUser");
		Error error = new Error();

		if (user == null) {
			res.sendRedirect(req.getContextPath());
			return;
		} else if (user.getBookingSiteURL() != null) {
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
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String cnpj = req.getParameter("cnpj");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		double dailyRate = Double.parseDouble(req.getParameter("dailyRate"));
		String city = req.getParameter("city");

		Hotel hotel = new Hotel(cnpj, name, phone, city, dailyRate);
		User user = new User( email, password, cnpj, null);

		dao.insert(hotel);
		uDAO.insert(user);
		res.sendRedirect("list");
	}

	private void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String cnpj = req.getParameter("cnpj");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		double dailyRate = Double.parseDouble(req.getParameter("dailyRate"));
		String city = req.getParameter("city");

		Hotel hotel = new Hotel(cnpj, name, phone, city, dailyRate);
		User user = new User( email, password, cnpj, null);

		dao.update(hotel);
		uDAO.update(user);
		res.sendRedirect("list");
	}

	private void remove(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String cnpj = req.getParameter("cnpj");

		User user = new User();
		user = uDAO.getByHotelCNPJ(cnpj);

		Hotel hotel = new Hotel(cnpj);
		dao.remove(hotel);
		uDAO.remove(user);
		res.sendRedirect("list");
	}

	//lista apenas dados do hotel
	private void listAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Hotel> hotelList = dao.listAllByCNPJ();

		req.setAttribute("hotelList", hotelList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/hotel/list.jsp");
		dispatcher.forward(req, res);
	}
	
	//lista os dados do hotel e da conta do hotel
	private void listAllAccounts(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Hotel> hotelList = dao.listAllByCNPJ();
		List<User> userList = uDAO.listAllByCNPJ();

		req.setAttribute("hotelList", hotelList);
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/hotel/list.jsp");
		dispatcher.forward(req, res);
	}
	
	
	private void listByCity(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Hotel> hotelList = dao.listByCity(req.getParameter("city"));

		req.setAttribute("hotelList", hotelList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/hotel/list.jsp");
		dispatcher.forward(req, res);
	}

	private void showRegisterForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/hotel/form.jsp");
		dispatcher.forward(req, res);
	}

	//passa os dados do hotel e da conta dele para editar
	private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cnpj = String.valueOf(req.getParameter("CNPJ"));
		Hotel hotel = dao.getByCNPJ(cnpj);
		User user = uDAO.getByHotelCNPJ(cnpj);
		req.setAttribute("hotel", hotel);
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/hotel/form.jsp");
		dispatcher.forward(req, res);
	}
}
