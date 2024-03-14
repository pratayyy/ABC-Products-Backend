package com.abcproducts.model;

public class Invoice {
	private Integer slNo;
	private Integer customerOrderId;
	private Integer salesOrg;
	private String distributionChannel;
	private Integer companyCode;
	private String orderCreationDate;
	private String orderCurrency;
	private Integer customerNumber;
	private Double amountInUsd;
	private Double orderAmount;

	public Invoice() {
		super();
	}

	public Invoice(Integer slNo, Integer customerOrderId, Integer salesOrg, String distributionChannel,
			Integer companyCode, String orderCreationDate, String orderCurrency, Integer customerNumber,
			Double amountInUsd, Double orderAmount) {
		super();
		this.slNo = slNo;
		this.customerOrderId = customerOrderId;
		this.salesOrg = salesOrg;
		this.distributionChannel = distributionChannel;
		this.companyCode = companyCode;
		this.orderCreationDate = orderCreationDate;
		this.orderCurrency = orderCurrency;
		this.customerNumber = customerNumber;
		this.amountInUsd = amountInUsd;
		this.orderAmount = orderAmount;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public Integer getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(Integer customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Integer getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(Integer salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Double getAmountInUsd() {
		return amountInUsd;
	}

	public void setAmountInUsd(Double amountInUsd) {
		this.amountInUsd = amountInUsd;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "Invoice [slNo=" + slNo + ", customerOrderId=" + customerOrderId + ", salesOrg=" + salesOrg
				+ ", distributionChannel=" + distributionChannel + ", companyCode=" + companyCode
				+ ", orderCreationDate=" + orderCreationDate + ", orderCurrency=" + orderCurrency + ", customerNumber="
				+ customerNumber + ", amountInUsd=" + amountInUsd + ", orderAmount=" + orderAmount + "]";
	}

}
