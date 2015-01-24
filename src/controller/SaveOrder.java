package controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.OrderDAO;
import dao.PaymentDAO;

import entity.OrderProduct;
import entity.OrderProductId;
import entity.Orders;


/**
 * Servlet implementation class SaveOrder
 */
@WebServlet("/SaveOrder")
public class SaveOrder
    extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    OrderDAO orderDao;
    PaymentDAO paymentDao;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveOrder()
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
        paymentDao = PaymentDAO.getPaymentDAO();

        Object obj = request.getSession().getAttribute("list");


        List<OrderProduct> list = new ArrayList<>();
        list = (List<OrderProduct>)obj;


        orderDao.saveOrderProduct(list);
        request.getSession().removeAttribute("list");
        request.getSession().removeAttribute("saved");
        request.getSession().removeAttribute("total1");
        request.getRequestDispatcher("main.jsp").forward(request, response);

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
