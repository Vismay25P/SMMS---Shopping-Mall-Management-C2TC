package com.cg.smms.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private int userId;

	private String name;
	private String type;
	private String password;

	@OneToOne(mappedBy = "user") // 1:1
	private Customer customer;

	@OneToOne(mappedBy = "user") // 1:1
	private ShopOwner shopOwner;

	@OneToOne(mappedBy = "user") // 1:1
	private MallAdmin mallAdmin;

	/* ------------------- GS------------------- */

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public MallAdmin getMallAdmin() {
		return mallAdmin;
	}

	public void setMallAdmin(MallAdmin mallAdmin) {
		this.mallAdmin = mallAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", type=" + type + ", password=" + password + ", customer="
				+ customer + ", shopOwner=" + shopOwner + ", mallAdmin=" + mallAdmin + "]";
	}

}
