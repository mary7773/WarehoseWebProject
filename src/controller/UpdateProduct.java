package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MapClass;
import dao.ProductsDAO;
import entity.Brands;
import entity.Categories;
import entity.Products;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductsDAO productDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String id = request.getParameter("hidden");
	    String name = request.getParameter("productName");
	    String quantity = request.getParameter("qty");
	    String price = request.getParameter("price");
	    String category = request.getParameter("category");
	    String brand = request.getParameter("brand");

	    int productId = Integer.parseInt(id);
	    double productProce = Double.parseDouble(price);
	    double productQuantity = Double.parseDouble(quantity);

	    productDao = ProductsDAO.getProductDAO();

	    MapClass map =  productDao.loadBrandAndCategory();
	    Map<String, Brands> mapBrands = map.getBrand();
	    Map<String, Categories> mapCategories = map.getCategory();

	    Products product = new Products();
	    product.setId(productId);
	    product.setName(name);
	    product.setPrice(productProce);
	    product.setQuantity(productQuantity);
	    product.setBrands(mapBrands.get(brand));
	    product.setCategories(mapCategories.get(category));

	    productDao.updateProduct(product);
	    
	    System.out.println(product.getName());


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
