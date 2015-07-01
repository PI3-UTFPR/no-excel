package br.edu.utfpr.controller.manager;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Data;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.TransactionService;
import br.edu.utfpr.util.JPAUtil;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/manager/transaction")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("customer") == null) {
			request.setAttribute("error", true);
			request.setAttribute("error_message",
					"Selecione um cliente");
		}

		String address = "/WEB-INF/views/manager/payment.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getById(Long.parseLong(id));

		if (customer != null) {

			Boolean operation = request.getParameter("type").equals("debit");

			Float postedValue = Float.parseFloat(request.getParameter("value")
					.replace(",", "."));
			BigDecimal value = new BigDecimal(Math.floor(postedValue * 100));
			BigDecimal customerValue = new BigDecimal(customer.getValue());
			BigDecimal newValue;

			if (operation) {
				newValue = customerValue.subtract(value);
			} else {
				newValue = customerValue.add(value);
			}

			if (newValue.compareTo(BigDecimal.ZERO) >= 0) {

				try {

					TransactionService transactionService = new TransactionService();
					Transaction transaction = new Transaction();
					transaction.setCustomer(customer);
					transaction.setOperation(operation);
					transaction.setValue(value);
					transaction.setDate(new Date());
					
					
					customer.setValue(new Long(newValue.intValue()));

						customerService.update(customer);
						transactionService.save(transaction);
						request.getSession().setAttribute("customer", customer);


				} catch (Exception e) {

					e.printStackTrace();
					request.setAttribute("error", true);
					request.setAttribute("error_message",
							"Erro realizar transação.");
				}

			} else {

				request.setAttribute("error", true);
				request.setAttribute("error_message",
						"Saldo insuficiente para esta operação.");

			}

			// System.out.println("===>" + );

		} else {

			request.setAttribute("error", true);
			request.setAttribute("error_message", "Nenhum cliente selecionado.");

		}

		String address = "/WEB-INF/views/manager/payment.jsp";
		// request.setAttribute("error", true);
		// request.setAttribute("error_message", "ABC");

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
