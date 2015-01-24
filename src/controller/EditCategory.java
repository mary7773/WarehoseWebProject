package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrandsDAO;
import dao.CategoriesDAO;
import entity.Brands;
import entity.Categories;

/**
 * Servlet implementation class EditCategory
 */
@WebServlet("/EditCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoriesDAO categoryDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategory() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    categoryDao = CategoriesDAO.getCategoryDAO();
        Map<String, Categories> categotyMap = categoryDao.getCategories();
        request.getSession().setAttribute("collection", categotyMap.keySet());
        request.getRequestDispatcher("editcategory.jsp").forward(request, response);


        String selectedCategory = request.getParameter("category");

        if (selectedCategory != null)
        {
            System.out.println("Selected category: " + selectedCategory);

            String newCategory = request.getParameter("categoryName");
            Categories cat = new Categories();
            cat.setId(categotyMap.get(selectedCategory).getId());
            cat.setName(newCategory);
            System.out.println("ID "+ cat.getId() + " NAME " + cat.getName());
            categoryDao.updateCategory(cat);



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
