package com.cg.smms.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "shopOwner")
public class ShopOwner implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private int SOId;

	private LocalDate dob;
	private String address;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "userId") // FK
	private User user;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "shopId") // FK
	private Shop shop;

	/* ------------------- GS------------------- */

	public int getSOId() {
		return SOId;
	}

	public void setSOId(int sOId) {
		SOId = sOId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "ShopOwner [SOId=" + SOId + ", dob=" + dob + ", address=" + address + ", user=" + user + ", shop=" + shop
				+ "]";
	}

}
