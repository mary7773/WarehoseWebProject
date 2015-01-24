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
 * Servlet implementation class EditBrand
 */
@WebServlet("/EditBrand")
public class EditBrand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BrandsDAO brandDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBrand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    brandDao = BrandsDAO.getBrandDAO();
	    Map<String, Brands> brandMap = brandDao.getBrands();
	    request.getSession().setAttribute("collection", brandMap.keySet());
	    request.getRequestDispatcher("editbrand.jsp").forward(request, response);


	    String selectedBrand = request.getParameter("brand");

	    if (selectedBrand != null)
	    {
            System.out.println("Selected brand: " + selectedBrand);

            String newBrand = request.getParameter("brandName");
            Brands brand = new Brands();
            brand.setId(brandMap.get(selectedBrand).getId());
            brand.setName(newBrand);
            System.out.println("ID "+ brand.getId() + " NAME " + brand.getName());
            brandDao = BrandsDAO.getBrandDAO();
            brandDao.updateBrand(brand);


//            Map<String, Brands> brandMap1 = brandDao.getBrands();
//            request.setAttribute("collection", brandMap1.keySet());

	    }


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
