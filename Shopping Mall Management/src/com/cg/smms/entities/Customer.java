package com.cg.smms.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private int customerId;

	private String phone;
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // 1:M
	private List<OrderDetails> orders = new ArrayList<>();// order

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "userId") // FK
	private User user;

	@ManyToOne // M:1
	@JoinColumn(name = "shop_id") // FK
	private Shop shop;

	/* ------------------- GS------------------- */

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", orders=" + orders + ", phone=" + phone + ", email=" + email
				+ ", user=" + user + ", shop=" + shop + "]";
	}

}
