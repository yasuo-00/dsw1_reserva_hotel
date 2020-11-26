package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.SaleOffDAO;

public class SaleOffController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private SaleOffDAO dao;
	
	@Override
	public void init() {
		dao = new SaleOffDAO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	}
}
