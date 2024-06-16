package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.productType;
import service.MegaService;

@WebServlet("/mega")
public class MegaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("megas", MegaService.findAll());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("mega.jsp");
//		dispatcher.forward(request, response);
		
		request.setAttribute("all", MegaService.All());
		request.setAttribute("type", MegaService.product_type());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mega.jsp");
		
		dispatcher.forward(request, response);
		
	}
}
