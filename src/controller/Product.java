package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrandsDAO;
import dao.CategoriesDAO;
import dao.MapClass;
import dao.ProductsDAO;
import entity.Brands;
import entity.Categories;
import entity.Products;


/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product
    extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    BrandsDAO brandDao;
    CategoriesDAO categoryDao;
    ProductsDAO productDao;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product()
    {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {

        // brandDao = BrandsDAO.getBrandDAO();
        // Map<String, Brands> brandsMap = brandDao.getBrands();

        Map<String, Brands> brandsMap = new HashMap<>();

        productDao = ProductsDAO.getProductDAO();
        MapClass mapClass = productDao.loadBrandAndCategory();

        brandsMap = mapClass.getBrand();

        request.getSession().setAttribute("collection", brandsMap.keySet());
        // request.getRequestDispatcher("product.jsp").forward(request, response);

        // categoryDao = CategoriesDAO.getCategoryDAO();
        // Map<String, Categories> categoryNap = categoryDao.getCategories();

        Map<String, Categories> categoryNap = new HashMap<>();
        categoryNap = mapClass.getCategory();
        request.getSession().setAttribute("collection1", categoryNap.keySet());
        request.getRequestDispatcher("product.jsp").forward(request, response);

        String name = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");

        double p = 0;
        double q = 0;

        try
        {

            if (quantity != null && price != null)
            {
                p = Double.parseDouble(price);
                q = Double.parseDouble(quantity);

                Products product = new Products();
                product.setName(name);
                product.setQuantity(q);
                product.setPrice(p);
                product.setBrands(brandsMap.get(brand));
                product.setCategories(categoryNap.get(category));

                ProductsDAO productDao = ProductsDAO.getProductDAO();
                productDao.addProduct(product);
            }

        }
        catch (NumberFormatException e)
        {
            // response.sendRedirect("error.jsp");
            System.out.println("Error! Wrong values!");
        }

        System.out.println(name + " " + category + " " + brand);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }

}
