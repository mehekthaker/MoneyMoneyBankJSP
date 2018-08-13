package com.moneymoney.app.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.moneymoney.app.model.account.pojo.MMCurrentAccount;
import com.moneymoney.app.model.account.pojo.MMCustomer;
import com.moneymoney.app.model.account.pojo.MMSavingsAccount;
import com.moneymoney.app.model.service.ServiceImpl;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

/**
 * Servlet implementation class AppController
 */
@WebServlet("*.app")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceImpl serviceImpl = new ServiceImpl();
	Map<String, String> loginDetails = new HashMap<>();
	BankAccount account = null;

	/**
	 * Default constructor.
	 */
	public AppController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		// HttpSession session = request.getSession();
		System.out.println(action);

		switch (action) {
		case "/refresh.app":
			response.sendRedirect("home.jsp");
			break;

		case "/addNewAccount.app":
			response.sendRedirect("addNewAccount.jsp");
			break;

		case "/add.app":
			String accountHolder = request.getParameter("accountHolderName");
			String emailId = request.getParameter("emailId");
			String dob = request.getParameter("dob");
			String phnum = request.getParameter("contactNo");

			MMCustomer activeCustomer = new MMCustomer(accountHolder, Long.parseLong(phnum), dob, emailId);

			String choice = request.getParameter("accountType");
			String balance, odLimit = null;
			boolean sal;

			if (choice.equals("savingAccount")) {
				String type = request.getParameter("salary");
				System.out.println(type);
				if (type.equals("sTicked")) {
					sal = true;
					balance = request.getParameter("salbal");
				} else {
					balance = request.getParameter("bal");
					sal = false;
				}
				account = new MMSavingsAccount(activeCustomer, Double.parseDouble(balance), sal);
			} else {
				balance = request.getParameter("cbal");
				odLimit = request.getParameter("odLimit");
				account = new MMCurrentAccount(activeCustomer, Double.parseDouble(balance),
						Double.parseDouble(odLimit));
			}
			System.out.println(accountHolder + "" + emailId + "" + dob + "" + phnum + "" + choice + "" + balance + ""
					+ odLimit + "" + account.getAccountNumber());

			activeCustomer.setAccountNumber(account.getAccountNumber());

			serviceImpl.addBankAccount(account);
			serviceImpl.addCustomer(activeCustomer);
			request.setAttribute("accNo", account.getAccountNumber());
			RequestDispatcher dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);

		case "/searchAcc.app":
			int num = Integer.parseInt(request.getParameter("accNo"));
			request.setAttribute("accNo", num);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;

		case "/displayAccount.app":
			if (serviceImpl.searchAccountById(((int) request.getAttribute("accNo"))) == null) {
				response.sendRedirect("AccountNotFound.jsp");
			} else {
				account = serviceImpl.searchAccountById((int) request.getAttribute("accNo"));
				String classType = account.getClass().getSimpleName();
				System.out.println(classType);
				request.setAttribute("bankAccount", account);
				request.setAttribute("classType", classType);
				dispatcher = request.getRequestDispatcher("ViewAccount.jsp");
				dispatcher.forward(request, response);
			}
			break;

		case "/withdrawAmount.app":
			response.sendRedirect("withdraw.jsp");
			break;

		case "/depositAmount.app":
			response.sendRedirect("deposit.jsp");
			break;

		case "/withdraw.app":
			int accNo = Integer.parseInt(request.getParameter("accNo"));
			double amount = Double.parseDouble(request.getParameter("withdrawamount"));
			String msg = serviceImpl.withdraw(accNo, amount);
			System.out.println(msg);
			request.setAttribute("accNo", accNo);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;

		case "/deposit.app":
			accNo = Integer.parseInt(request.getParameter("accNo"));
			amount = Double.parseDouble(request.getParameter("depositamount"));
			serviceImpl.deposit(accNo, amount);
			request.setAttribute("accNo", accNo);
			System.out.println(accNo + "  jkbdabk  " + amount);
			dispatcher = request.getRequestDispatcher("displayAccount.app");
			dispatcher.forward(request, response);
			break;

		case "/searchAccount.app":
			response.sendRedirect("searchAcc.jsp");
			break;

		case "/fundTransfer.app":
			response.sendRedirect("payment.jsp");
			break;

		case "/transfer.app":
			int sender = Integer.parseInt(request.getParameter("sender"));
			int reciever = Integer.parseInt(request.getParameter("reciever"));
			amount = Double.parseDouble(request.getParameter("amount"));
			System.out.println(sender + " " + amount + " " + reciever);
			msg = serviceImpl.withdraw(sender, amount);
			System.out.println(msg);
			serviceImpl.deposit(reciever, amount);
			request.setAttribute("sender", sender);
			request.setAttribute("reciever", reciever);
			request.setAttribute("amount", amount);
			dispatcher = request.getRequestDispatcher("fundTransfer.jsp");
			dispatcher.forward(request, response);
			break;

		case "/viewAllCustomers.app":
			ArrayList<Customer> cust = serviceImpl.viewAllCustomers();
			request.setAttribute("customers", cust);
			dispatcher = request.getRequestDispatcher("viewAllCustomers.jsp");
			dispatcher.forward(request, response);
			break;

		default:
			response.sendRedirect("home.jsp");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
