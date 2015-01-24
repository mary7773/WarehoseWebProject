package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import entity.OrderProduct;
import entity.OrderProductId;
import entity.Orders;
import entity.Products;
import entity.Users;


/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrder")
public class AddOrder
    extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    OrderDAO orderDao;
    OrderProduct orderProduct;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder()
    {
        super();

    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        orderDao = OrderDAO.getOrderDAO();
        Map<String, Products> productMap = orderDao.getProducts();
        Map<String, Users> customerMap = orderDao.getCustomers();

        orderProduct = new OrderProduct();

        String customer = request.getParameter("customer");
        String product = request.getParameter("product");
        String qty = request.getParameter("qty");

        // System.out.println(customer + " " + product + " " + qty);
        Users selectedCustomer = new Users();

        for (String c : customerMap.keySet())
        {
            if (c.equals(customer))
            {
                selectedCustomer = customerMap.get(c);
                break;
            }
        }
        Products selectedProduct = new Products();

        for (String p : productMap.keySet())
        {
            if (p.equals(product))
            {
                selectedProduct = productMap.get(p);
                break;
            }
        }

        System.out.println(selectedCustomer.getFirstName() + " ; " + selectedProduct.getQuantity());

        long quantity = 0;
        try
        {
            quantity = Long.parseLong(qty);
        }
        catch (Exception e)
        {
            System.out.println("Wrong number format!");
        }
        List<OrderProduct> list = null;
        Object listObj = request.getSession().getAttribute("list");

        if (listObj != null)
        {
            list = (List<OrderProduct>)listObj;
        }
        else
        {
            list = new ArrayList<>();
        }

        orderProduct.setProducts(selectedProduct);
        orderProduct.setQuantity(quantity);




        Orders order = new Orders();
        order.setIsPaid(false);
        order.setOrderDate(new Date());
        order.setUsers(selectedCustomer);

        Object orderObj = request.getSession().getAttribute("order");

        if (orderObj != null)
        {
            order = (Orders)orderObj;
            orderProduct.setOrders(order);

        }

        request.getSession().setAttribute("order", order);


        Calendar c = Calendar.getInstance();


            if (orderProduct.getProducts().getQuantity() < orderProduct.getQuantity())
            {
                c.setTime(new Date()); // Now use today date.
                c.add(Calendar.DATE, 7); // Adding 7 days
                order.setTimeOfDelivery(c.getTime());

                System.out.println(order.getTimeOfDelivery());
            }
            else
            {
                c.setTime(new Date()); // Now use today date.
                c.add(Calendar.DATE, 1); // Adding 1 days
                order.setTimeOfDelivery(c.getTime());

                System.out.println(order.getTimeOfDelivery());
            }

            boolean isSaved = false;

            Object savedObj = request.getSession().getAttribute("saved");



            if (savedObj != null)
            {
                isSaved = (boolean)savedObj;
            }

            if (!isSaved)
            {
                orderDao.saveOrder(order);
                orderProduct.setOrders(order);
                isSaved = true;
            }

            request.getSession().setAttribute("saved", isSaved);

           OrderProductId id = new OrderProductId();
           id.setOrderId(order.getId());
           id.setProductId(selectedProduct.getId());
           orderProduct.setId(id);


        list.add(orderProduct);

        double sum = 0;
        Object sumtObj = request.getSession().getAttribute("total1");

        if (sumtObj != null)
        {
            sum = (double)sumtObj;


        }


        for (OrderProduct orderProduct1 : list)
        {
            sum += orderProduct1.getTotal();

        }
        request.getSession().setAttribute("total1", sum);
//        orderDao.saveOrderProduct(list);
        request.getSession().setAttribute("list", list);
//        request.getSession().setAttribute("total1", sum);
        request.getRequestDispatcher("orders.jsp").forward(request, response);

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
