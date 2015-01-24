package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.BrandsDAO;
import dao.LoginDAO;
import dao.UsersDAO;
import entity.Brands;
import entity.Users;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login
    extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    UsersDAO userDao;
    LoginDAO loginDao;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login()
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
        Users user = new Users();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));

        String userName = (String)user.getUserName();
        String password = user.getPassword();

        userDao = UsersDAO.getInst();
        List<Users> list = userDao.getUsers();

        PrintWriter out = response.getWriter();

        for (Users users : list)
        {
            out.println(users.getFirstName());
            if (users.getUserName().equals(userName))
            {
                user.setId(users.getId());
                user.setUsersGroups(users.getUsersGroups());
                break;
            }
        }

        BrandsDAO brandDao = BrandsDAO.getBrandDAO();
        Map<String, Brands> brandsMap = brandDao.getBrands();


        if (login(userName, password))
        {

            System.out.println("LOGGED");

            Boolean admin = false;
            if (1 == (user.getUsersGroups().getId()))
            {
                admin = true;
                out.println("You are admin");

                request.getSession().setAttribute("collection", brandsMap.keySet());
                request.getRequestDispatcher("main.jsp").forward(request, response);
//                request.getSession().setAttribute("collection", ls);
               // response.sendRedirect("main.jsp");

            }
            else if (2 == (user.getUsersGroups().getId()))
            {
                out.println("You are employee");
                response.sendRedirect("main2.jsp");
            }
            else
            {
                response.sendRedirect("login.jsp");
                out.println("You do not have access to the application");
            }
        }
        else
        {
            response.sendRedirect("login.jsp");
            System.out.println("NOT LOGGED");
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }


    protected boolean login(String userName, String password)
    {
        Boolean logged = false;
        loginDao = LoginDAO.getLoginDAO();
        List<Users> userList = loginDao.loginCheck(userName);

        for (Users user : userList)
        {
            if (user.getPassword().equals(password))

            {
                logged = true;
                break;
            }

        }

        return logged;
    }
}
