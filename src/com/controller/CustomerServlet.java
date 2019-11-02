package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Customer;
import com.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService service = new CustomerService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String action = request.getParameter("action");
		System.out.println(action);
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

			Customer customer = service.getCustomerDetails(ssnid, custid);
			if (customer != null) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("Search.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("error.jsp?searchid="+121).forward(request, response);
			}

		} else if (action != null && action.equalsIgnoreCase("update")) {
			
			int ssnid = 0;
			int custid = Integer.parseInt(request.getParameter("custid"));
			System.out.println(custid);
			int a=service.updateCustomerStatusInProgress(custid);
			if(a>0)
			{
				System.out.println("inprogress");
			}
			Customer customer = service.getCustomerDetails(ssnid, custid);
			if (customer != null) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("updateCust.jsp").forward(request, response);
			}
		} else if (action != null && action.equalsIgnoreCase("delete")) {

			int custid = Integer.parseInt(request.getParameter("custid"));
			System.out.println(custid);
			int a = service.deleteCustomer(custid);
			if (a > 0) {
				
				request.getRequestDispatcher("success.jsp?custid1=" + custid).forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("error.jsp?custid1=" + custid).forward(request, response);
			}
		}
		else if (action != null && action.equalsIgnoreCase("statuscust")) {
			ArrayList<Customer> custList=service.getCustomerStatus();
			if(custList!=null)
			{
				request.setAttribute("customer",custList);
				request.getRequestDispatcher("ViewCustDetails.jsp").forward(request, response);
			}

		}
		else if (action != null && action.equalsIgnoreCase("deleteaccount")) {
			int custid = Integer.parseInt(request.getParameter("custid"));
			ArrayList<Integer> accidList=service.deleteCustomerAccount(custid);
			if(accidList!=null)
			{
				request.setAttribute("accidList", accidList);
				request.getRequestDispatcher("AccountInActive.jsp").forward(request, response);
			}
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equalsIgnoreCase("register")) {
			int ssnid = Integer.parseInt(request.getParameter("ssnid"));
			String name = request.getParameter("custname");
			int age = Integer.parseInt(request.getParameter("age"));
			String add1 = request.getParameter("add1");
			String add2 = request.getParameter("add2");
			if (add1 == null) {
				add1 = " ";
			}
			if (add2 == null) {
				add2 = " ";
			}
			String address = add1 + " " + add2;
			String city = request.getParameter("city");
			String state = request.getParameter("state");

			Customer customer = new Customer();
			customer.setSSN(ssnid);
			customer.setName(name);
			customer.setAge(age);
			customer.setAddress(address);
			customer.setCity(city);
			customer.setState(state);

			int result = service.registerCustomer(customer);
			if (result > 0) {
				int a = service.createCustomerStatus(ssnid);
				if (a > 0) {
					System.out.println("status");
				}
				request.getRequestDispatcher("success.jsp?ssnid=" +ssnid).forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp?ssnid="+ssnid).forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("Edit")) {
			int custid = Integer.parseInt(request.getParameter("custid"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			int age = Integer.parseInt(request.getParameter("age"));
			int res = service.updateCustomer(custid, name, address, age);
			if (res > 0) {
				int a = service.updateCustomerStatus(custid);
				if (a > 0) {
					System.out.println("completed");
				}
				request.getRequestDispatcher("success.jsp?custid8=" + custid).forward(request, response);
			} else
				request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
