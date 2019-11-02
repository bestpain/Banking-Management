package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Account;
import com.model.Customer;
import com.service.AccountService;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountService service=new AccountService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Search")) {
			int ssnid = 0;
			int custid = 0;
			String str1 = request.getParameter("ssnid");
			if (str1 == null || str1 == "") {
				ssnid = 0;
			} else {
				ssnid = Integer.parseInt(request.getParameter("ssnid"));
			}
			System.out.println(ssnid);
			String str = request.getParameter("custid");
			if (str == null || str == "") {
				custid = 0;

			} else {
				custid = Integer.parseInt(request.getParameter("custid"));
			}
			System.out.println(custid);

			ArrayList<Account> accList = service.getAccountDetails(ssnid, custid);
			if (accList != null) {
				request.setAttribute("account", accList);
				request.getRequestDispatcher("accdetails.jsp").forward(request, response);
			}
		}

		if (action != null && action.equalsIgnoreCase("delete")) {

			int accid = Integer.parseInt(request.getParameter("accid"));
			System.out.println(accid);
			int a = service.deleteAccount(accid);
			System.out.println(a);
			if (a > 0) {
				request.getRequestDispatcher("success.jsp?accid1="+accid).forward(request, response);
			}
			else{
				request.getRequestDispatcher("error.jsp?accid1="+accid).forward(request, response);
			}
		}
		 if (action != null && action.equalsIgnoreCase("statusacct")) {
			ArrayList<Account> acctList=service.getAccountStatus();
			if(acctList!=null)
			{
				request.setAttribute("account",acctList);
				request.getRequestDispatcher("viewaccountstatus.jsp").forward(request, response);
			}

		}
		 if (action != null && action.equalsIgnoreCase("deleteconfirm")) {
			 int custid=Integer.parseInt(request.getParameter("custid"));
			 ArrayList<Account> accList=service.getAccountBalance(custid);
			 if(accList!=null)
			 {
				 request.setAttribute("acclist",accList);
				 request.getRequestDispatcher("DeleteConfirmation.jsp?custid="+custid).forward(request, response);
			 }
		 }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int custid=Integer.parseInt(request.getParameter("custid"));
		String acctype=request.getParameter("accType");
		double balance=Double.parseDouble(request.getParameter("damount"));
		int a=service.createAccount(custid, acctype, balance);
		if(a>0)
		{
			int res=service.createAccountStatus(custid, acctype);
			if(res>0)
			{
				System.out.println("created");
			}
			request.getRequestDispatcher("success.jsp?custid2=" + custid).forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("error.jsp?custid2=" + custid).forward(request, response);
		}
		
	}

}
