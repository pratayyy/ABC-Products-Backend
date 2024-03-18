package com.abcproducts.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcproducts.implementation.InvoiceDao;
import com.abcproducts.implementation.InvoiceDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/invoices/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvoiceDao invoiceDao;

	public DeleteServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		invoiceDao = new InvoiceDaoImpl();
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Gson gson = new Gson();
		JsonObject jsonResponse = new JsonObject();

		Integer customerOrderId = Integer.parseInt(request.getParameter("id"));

		try {
			if (invoiceDao.getSearchedInvoices(customerOrderId).isEmpty()) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				jsonResponse.addProperty("status", "failed");
				jsonResponse.addProperty("message", "No invoice found for the given id");
				response.getWriter().write(gson.toJson(jsonResponse));
			} else {
				invoiceDao.deleteInvoice(customerOrderId);
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
