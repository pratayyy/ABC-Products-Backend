package com.abcproducts.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcproducts.implementation.InvoiceDao;
import com.abcproducts.implementation.InvoiceDaoImpl;
import com.abcproducts.model.Invoice;
import com.google.gson.Gson;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvoiceDao invoiceDao;

	public SearchServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		invoiceDao = new InvoiceDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");

		Gson gson = new Gson();
		int customerOrderId = Integer.parseInt(request.getParameter("id"));

		try {
			List<Invoice> invoices = invoiceDao.getSearchedInvoices(customerOrderId);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(invoices));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
