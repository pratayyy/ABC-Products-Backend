package com.abcproducts.implementation;

import java.util.List;

import com.abcproducts.model.Invoice;

public interface InvoiceDao {

	List<Invoice> getAllInvoices(Integer start, Integer limit);
	
	List<Invoice> getSearchedInvoices(Integer customerOrderId);

	void insertInvoice(Invoice invoice);

	void updateInvoice(Integer customerOrderId, Invoice invoice);

	void deleteInvoice(Integer customerOrderId);
}
