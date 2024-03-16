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
	private static final String SELECT_SEARCHED_INVOICE = "SELECT * FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?";
	private static final String MAX_SERIAL_NUMBER = "SELECT MAX(Sl_no) AS MaxSerialNumber FROM h2h_oap";
	private static final String INSERT_INVOICE = "INSERT INTO h2h_oap"
			+ "(Sl_NO, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE,ORDER_CREATION_DATE, ORDER_CURRENCY, CUSTOMER_NUMBER, AMOUNT_IN_USD, ORDER_AMOUNT)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_INVOICE = "UPDATE h2h_oap SET ORDER_CURRENCY = ?, COMPANY_CODE = ?, DISTRIBUTION_CHANNEL = ? WHERE CUSTOMER_ORDER_ID = ?";
	private static final String DELETE_INVOICE = "DELETE FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?";

	private DatabaseConnection dbConn;

	public InvoiceDaoImpl() {
		dbConn = new DatabaseConnection();
	}

	@Override
	public List<Invoice> getAllInvoices(Integer start, Integer limit) {
		List<Invoice> invoices = new ArrayList<>();
		try (Connection conn = dbConn.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_INVOICES);
			stmt.setInt(1, start);
			stmt.setInt(2, limit);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Invoice invoice = new Invoice(rs.getInt("Sl_no"), rs.getInt("CUSTOMER_ORDER_ID"),
						rs.getInt("SALES_ORG"), rs.getString("DISTRIBUTION_CHANNEL"), rs.getString("DIVISION"),
						rs.getDouble("RELEASED_CREDIT_VALUE"), rs.getString("PURCHASE_ORDER_TYPE"),
						rs.getInt("COMPANY_CODE"), rs.getString("ORDER_CREATION_DATE"),
						rs.getString("ORDER_CREATION_TIME"), rs.getString("CREDIT_CONTROL_AREA"),
						rs.getInt("SOLD_TO_PARTY"), rs.getDouble("ORDER_AMOUNT"),
						rs.getString("REQUESTED_DELIVERY_DATE"), rs.getString("ORDER_CURRENCY"),
						rs.getString("CREDIT_STATUS"), rs.getInt("CUSTOMER_NUMBER"), rs.getDouble("AMOUNT_IN_USD"));
				invoices.add(invoice);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoices;
	}

	@Override
	public List<Invoice> getSearchedInvoices(Integer customerOrderId) {
		List<Invoice> invoices = new ArrayList<>();
		try (Connection conn = dbConn.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(SELECT_SEARCHED_INVOICE);
			stmt.setInt(1, customerOrderId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Invoice invoice = new Invoice(rs.getInt("Sl_no"), rs.getInt("CUSTOMER_ORDER_ID"),
						rs.getInt("SALES_ORG"), rs.getString("DISTRIBUTION_CHANNEL"), rs.getString("DIVISION"),
						rs.getDouble("RELEASED_CREDIT_VALUE"), rs.getString("PURCHASE_ORDER_TYPE"),
						rs.getInt("COMPANY_CODE"), rs.getString("ORDER_CREATION_DATE"),
						rs.getString("ORDER_CREATION_TIME"), rs.getString("CREDIT_CONTROL_AREA"),
						rs.getInt("SOLD_TO_PARTY"), rs.getDouble("ORDER_AMOUNT"),
						rs.getString("REQUESTED_DELIVERY_DATE"), rs.getString("ORDER_CURRENCY"),
						rs.getString("CREDIT_STATUS"), rs.getInt("CUSTOMER_NUMBER"), rs.getDouble("AMOUNT_IN_USD"));
				invoices.add(invoice);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoices;
	}

	@Override
	public void insertInvoice(Invoice invoice) {
		try (Connection conn = dbConn.getConnection()) {
			Integer nextSerialNumber;
			PreparedStatement getNextSerialNumberPreparedStatement = conn.prepareStatement(MAX_SERIAL_NUMBER);
			ResultSet rs = getNextSerialNumberPreparedStatement.executeQuery();
			while (rs.next()) {
				Integer maxSerialNumber = rs.getInt("MaxSerialNumber");
				nextSerialNumber = maxSerialNumber + 1;
				invoice.setSlNo(nextSerialNumber);
			}
			PreparedStatement stmt = conn.prepareStatement(INSERT_INVOICE);
			stmt.setInt(1, invoice.getSlNo());
			stmt.setInt(2, invoice.getCustomerOrderId());
			stmt.setInt(3, invoice.getSalesOrg());
			stmt.setString(4, invoice.getDistributionChannel());
			stmt.setInt(5, invoice.getCompanyCode());
			stmt.setString(6, invoice.getOrderCreationDate());
			stmt.setString(7, invoice.getOrderCurrency());
			stmt.setInt(8, invoice.getCustomerNumber());
			stmt.setDouble(9, invoice.getAmountInUsd());
			stmt.setDouble(10, 0);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateInvoice(Integer customerOrderId, Invoice invoice) {
		try (Connection conn = dbConn.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(UPDATE_INVOICE);
			stmt.setString(1, invoice.getOrderCurrency());
			stmt.setInt(2, invoice.getCompanyCode());
			stmt.setString(3, invoice.getDistributionChannel());
			stmt.setInt(4, customerOrderId);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInvoice(Integer customerOrderId) {
		try (Connection conn = dbConn.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(DELETE_INVOICE);
			stmt.setInt(1, customerOrderId);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
