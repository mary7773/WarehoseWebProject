package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import entity.Products;
import entity.Users;

/**
 * Servlet implementation class LoadOrder
 */
@WebServlet("/LoadOrder")
public class LoadOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDAO orderDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadOrder() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    orderDao = OrderDAO.getOrderDAO();
	   Map<String, Users> customerMap = orderDao.getCustomers();
	   Map<String, Products> productsMap = orderDao.getProducts();
	   request.getSession().setAttribute("collection", customerMap.keySet());
	   request.getSession().setAttribute("collection1", productsMap.keySet());
	   request.getSession().setAttribute("date", new Date());
       request.getRequestDispatcher("orders.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
