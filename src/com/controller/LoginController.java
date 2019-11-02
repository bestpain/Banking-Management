package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao dao=new LoginDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("login"))
		{
			int val;
			String uname=request.getParameter("idno");
			String pass=request.getParameter("pswd");
			val=dao.verify(uname, pass);
			if(val>0)
			{
				HttpSession session=request.getSession();
				session.setAttribute("username",uname);
				request.getRequestDispatcher("CustExecLogin.jsp").forward(request, response);
			}
			else
			{
				System.out.println("In error");
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
		}
		
		if(action.equalsIgnoreCase("logout"))
		{
			System.out.println("inside logout do-post");
			HttpSession session=request.getSession();
			session.invalidate();
			
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
		
	}

	
}
