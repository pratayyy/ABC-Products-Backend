package com.abcproducts.model;

import com.google.gson.annotations.SerializedName;

public class Invoice {
	@SerializedName("Sl_no")
	private Integer slNo;

	@SerializedName("CUSTOMER_ORDER_ID")
	private Integer customerOrderId;

	@SerializedName("SALES_ORG")
	private Integer salesOrg;

	@SerializedName("DISTRIBUTION_CHANNEL")
	private String distributionChannel;

	@SerializedName("DIVISION")
	private String division;

	@SerializedName("RELEASED_CREDIT_VALUE")
	private Double releasedCreditValue;

	@SerializedName("PURCHASE_ORDER_TYPE")
	private Integer purchaseOrderType;

	@SerializedName("COMPANY_CODE")
	private Integer companyCode;

	@SerializedName("ORDER_CREATION_DATE")
	private String orderCreationDate;

	@SerializedName("ORDER_CREATION_TIME")
	private String orderCreationTime;

	@SerializedName("CREDIT_CONTROL_AREA")
	private String creditControlArea;

	@SerializedName("SOLD_TO_PARTY")
	private Integer soldToParty;

	@SerializedName("ORDER_AMOUNT")
	private Double orderAmount;

	@SerializedName("REQUESTED_DELIVERY_DATE")
	private String requestedDeliveryDate;

	@SerializedName("ORDER_CURRENCY")
	private String orderCurrency;

	@SerializedName("CREDIT_STATUS")
	private String creditStatus;

	@SerializedName("CUSTOMER_NUMBER")
	private Integer customerNumber;

	@SerializedName("AMOUNT_IN_USD")
	private Double amountInUsd;

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

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Double getReleasedCreditValue() {
		return releasedCreditValue;
	}

	public void setReleasedCreditValue(Double releasedCreditValue) {
		this.releasedCreditValue = releasedCreditValue;
	}

	public Integer getPurchaseOrderType() {
		return purchaseOrderType;
	}

	public void setPurchaseOrderType(Integer purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
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

	public String getOrderCreationTime() {
		return orderCreationTime;
	}

	public void setOrderCreationTime(String orderCreationTime) {
		this.orderCreationTime = orderCreationTime;
	}

	public String getCreditControlArea() {
		return creditControlArea;
	}

	public void setCreditControlArea(String creditControlArea) {
		this.creditControlArea = creditControlArea;
	}

	public Integer getSoldToParty() {
		return soldToParty;
	}

	public void setSoldToParty(Integer soldToParty) {
		this.soldToParty = soldToParty;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(String requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
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

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(Integer slNo, Integer customerOrderId, Integer salesOrg, String distributionChannel, String division,
			Double releasedCreditValue, Integer purchaseOrderType, Integer companyCode, String orderCreationDate,
			String orderCreationTime, String creditControlArea, Integer soldToParty, Double orderAmount,
			String requestedDeliveryDate, String orderCurrency, String creditStatus, Integer customerNumber,
			Double amountInUsd) {
		super();
		this.slNo = slNo;
		this.customerOrderId = customerOrderId;
		this.salesOrg = salesOrg;
		this.distributionChannel = distributionChannel;
		this.division = division;
		this.releasedCreditValue = releasedCreditValue;
		this.purchaseOrderType = purchaseOrderType;
		this.companyCode = companyCode;
		this.orderCreationDate = orderCreationDate;
		this.orderCreationTime = orderCreationTime;
		this.creditControlArea = creditControlArea;
		this.soldToParty = soldToParty;
		this.orderAmount = orderAmount;
		this.requestedDeliveryDate = requestedDeliveryDate;
		this.orderCurrency = orderCurrency;
		this.creditStatus = creditStatus;
		this.customerNumber = customerNumber;
		this.amountInUsd = amountInUsd;
	}

	@Override
	public String toString() {
		return "Invoice [slNo=" + slNo + ", customerOrderId=" + customerOrderId + ", salesOrg=" + salesOrg
				+ ", distributionChannel=" + distributionChannel + ", division=" + division + ", releasedCreditValue="
				+ releasedCreditValue + ", purchaseOrderType=" + purchaseOrderType + ", companyCode=" + companyCode
				+ ", orderCreationDate=" + orderCreationDate + ", orderCreationTime=" + orderCreationTime
				+ ", creditControlArea=" + creditControlArea + ", soldToParty=" + soldToParty + ", orderAmount="
				+ orderAmount + ", requestedDeliveryDate=" + requestedDeliveryDate + ", orderCurrency=" + orderCurrency
				+ ", creditStatus=" + creditStatus + ", customerNumber=" + customerNumber + ", amountInUsd="
				+ amountInUsd + "]";
	}

}
