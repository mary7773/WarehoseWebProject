package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrandsDAO;
import entity.Brands;

/**
 * Servlet implementation class Brand
 */
@WebServlet("/Brand")
public class Brand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BrandsDAO brandDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Brand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String brandName = request.getParameter("brandName");

	    brandDao = BrandsDAO.getBrandDAO();
	    Brands brand = new Brands();
	    brand.setName(brandName);
	    brandDao.addBrand(brand);

	    response.sendRedirect("brand.jsp");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
