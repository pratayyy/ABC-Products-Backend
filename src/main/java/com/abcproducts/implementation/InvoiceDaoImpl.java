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
	private static final String MAX_SERIAL_NUMBER = "SELECT MAX(Sl_no) AS MaxSerialNumber FROM h2h_oap";
	private static final String INSERT_INVOICE = "INSERT INTO h2h_oap"
			+ "(Sl_NO, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE,ORDER_CREATION_DATE, ORDER_CURRENCY, CUSTOMER_NUMBER, AMOUNT_IN_USD, ORDER_AMOUNT)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_INVOICE = "UPDATE h2h_oap SET ORDER_CURRENCY = ?, COMPANY_CODE = ?, DISTRIBUTION_CHANNEL = ? WHERE CUSTOMER_ORDER_ID = ?";
	private static final String DELETE_INVOICE = "DELETE FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?";

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

	@Override
	public void insertInvoice(Invoice invoice) {
		try (Connection connection = databaseConnection.getConnection()) {
			Integer nextSerialNumber;
			PreparedStatement getNextSerialNumberPreparedStatement = connection.prepareStatement(MAX_SERIAL_NUMBER);
			ResultSet resultSet = getNextSerialNumberPreparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer maxSerialNumber = resultSet.getInt("MaxSerialNumber");
				nextSerialNumber = maxSerialNumber + 1;
				invoice.setSlNo(nextSerialNumber);
			}
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INVOICE);
			preparedStatement.setInt(1, invoice.getSlNo());
			preparedStatement.setInt(2, invoice.getCustomerOrderId());
			preparedStatement.setInt(3, invoice.getSalesOrg());
			preparedStatement.setString(4, invoice.getDistributionChannel());
			preparedStatement.setInt(5, invoice.getCompanyCode());
			preparedStatement.setString(6, invoice.getOrderCreationDate());
			preparedStatement.setString(7, invoice.getOrderCurrency());
			preparedStatement.setInt(8, invoice.getCustomerNumber());
			preparedStatement.setDouble(9, invoice.getAmountInUsd());
			preparedStatement.setDouble(10, 0);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateInvoice(Integer customerOrderId, Invoice invoice) {
		try (Connection connection = databaseConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INVOICE);
			preparedStatement.setString(1, invoice.getOrderCurrency());
			preparedStatement.setInt(2, invoice.getCompanyCode());
			preparedStatement.setString(3, invoice.getDistributionChannel());
			preparedStatement.setInt(4, customerOrderId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInvoice(Integer customerOrderId) {
		try (Connection connection = databaseConnection.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_INVOICE);
			preparedStatement.setInt(1, customerOrderId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
