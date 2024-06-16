package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MegaService;
/**
* Servlet implementation class CategoryMegaController
*/
@WebServlet("/categoryMega")
public class CategoryMegaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		request.setAttribute("megas", MegaService.pagingcategory(id));
		request.setAttribute("type", MegaService.product_type());
		RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
		dispatcher.forward(request, response);
	}
	
}

