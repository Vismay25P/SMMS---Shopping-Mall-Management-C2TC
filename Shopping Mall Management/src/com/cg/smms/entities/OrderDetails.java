package com.cg.smms.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private LocalDate dateOfPurchase;
	private float total;
	private String paymentMode;

	@ManyToOne // M:1
	@JoinColumn(name = "customerId") // FK
	private Customer customer;

	@ManyToOne // M:1
	@JoinColumn(name = "shopId") // FK
	private Shop shop;

	/* ------------------- GS------------------- */

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", dateOfPurchase=" + dateOfPurchase + ", total=" + total
				+ ", paymentMode=" + paymentMode + ", customer=" + customer + ", shop=" + shop + "]";
	}

}
