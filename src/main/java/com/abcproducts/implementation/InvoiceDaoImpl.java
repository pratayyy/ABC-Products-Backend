package com.abcproducts.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.abcproducts.connection.DatabaseConnection;
import com.abcproducts.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {

	private static final String SELECT_ALL_INVOICES = "SELECT * FROM h2h_oap LIMIT ?,?";

	private DatabaseConnection databaseConnection;

	public InvoiceDaoImpl() {
		databaseConnection = new DatabaseConnection();
	}

	@Override
	public List<Invoice> getAllInvoices(Integer start, Integer limit) {

		List<Invoice> invoices = new ArrayList<>();

		try (Connection connection = databaseConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INVOICES);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, limit);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Invoice invoice = new Invoice();
				invoice.setSlNo(resultSet.getInt("Sl_no"));
				invoice.setCustomerOrderId(resultSet.getInt("CUSTOMER_ORDER_ID"));
				invoice.setSalesOrg(resultSet.getInt("SALES_ORG"));
				invoice.setDistributionChannel(resultSet.getString("DISTRIBUTION_CHANNEL"));
				invoice.setCompanyCode(resultSet.getInt("COMPANY_CODE"));
				invoice.setOrderCreationDate(resultSet.getString("ORDER_CREATION_DATE"));
				invoice.setOrderCurrency(resultSet.getString("COMPANY_CODE"));
				invoice.setCustomerNumber(resultSet.getInt("CUSTOMER_NUMBER"));
				invoice.setAmountInUsd(resultSet.getDouble("AMOUNT_IN_USD"));
				invoice.setOrderAmount(resultSet.getDouble("ORDER_AMOUNT"));
				invoices.add(invoice);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return invoices;
	}

}
