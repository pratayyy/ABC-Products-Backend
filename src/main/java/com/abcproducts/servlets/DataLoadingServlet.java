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
import com.google.gson.JsonObject;

@WebServlet("/invoices/get")
public class DataLoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvoiceDao invoiceDao;

	public void init(ServletConfig config) throws ServletException {
		invoiceDao = new InvoiceDaoImpl();
	}

	public DataLoadingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));

		try {
			List<Invoice> invoices = invoiceDao.getAllInvoices(start, limit);
			response.setStatus(HttpServletResponse.SC_OK);
			jsonResponse.addProperty("status", "success");
			jsonResponse.add("invoices", gson.toJsonTree(invoices));
			response.getWriter().write(gson.toJson(jsonResponse));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
