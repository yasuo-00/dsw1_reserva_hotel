package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.BookingSiteDAO;
import br.ufscar.dc.dsw.dao.UserDAO;
import br.ufscar.dc.dsw.error.Error;

@WebServlet(urlPatterns = {"/BookingSite"})
public class BookingSiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookingSiteDAO dao;
	private UserDAO uDAO;

	@Override
	public void init() {
		dao = new BookingSiteDAO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req,res);
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
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		BookingSite bookingSite = new BookingSite(url, name, phone);
		User user = new User(name, email, password, null, url);

		dao.insert(bookingSite);
		uDAO.insert(user);
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getParameter("url");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		BookingSite bookingSite = new BookingSite(url, name, phone);
		User user = new User(name, email, password, null, url);

		dao.update(bookingSite);
		uDAO.update(user);
		response.sendRedirect("list");
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = request.getParameter("url");

		BookingSite bookingSite = new BookingSite(url);
		User user = new User();
		user = uDAO.getByBookingSiteURL(url);
		
		
		dao.remove(bookingSite);
		uDAO.remove(user);
		response.sendRedirect("list");
	}

	//lista todos os dados dos sites de reserva
	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BookingSite> bookingSiteList = dao.listAll();

		request.setAttribute("bookingSiteList", bookingSiteList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
	
	//lista todos os dados dos sites de reserva e da conta deles
	private void listAllAccounts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BookingSite> bookingSiteList = dao.listAllByURL();
		List<User> userList = uDAO.listAllByURL();

		request.setAttribute("bookingSiteList", bookingSiteList);
		request.setAttribute("userList", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
	
	private void showRegisterForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/bookingSite/form.jsp");
		dispatcher.forward(req, res);
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = String.valueOf(req.getParameter("URL"));
		BookingSite bookingSite = dao.getByURL(url);
		req.setAttribute("bookingSite", bookingSite);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/bookingSite/form.jsp");
		dispatcher.forward(req, res);
	}
}
