package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.html.HTMLTableElement;
import org.w3c.dom.html.HTMLTableRowElement;

import dao.ProductsDAO;
import entity.Products;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductsDAO productDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProduct() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("hidden");
		//HTMLTableRowElement tr = (HTMLTableRowElement)id;
		System.out.println(id);
		int productId = Integer.parseInt(id);
		productDao = ProductsDAO.getProductDAO();
		List<Products> productList = productDao.loadProducts();

		Products editableProduct = new Products();


		for (Products product : productList)
        {
		    if (product.getId() == productId)
            {
		        editableProduct = product;
		        break;
            }
        }
		List<Products> list = new ArrayList<>();
		list.add(editableProduct);

		System.out.println(editableProduct.getName());

		request.getSession().setAttribute("collection", list);

		request.getRequestDispatcher("editproduct2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
