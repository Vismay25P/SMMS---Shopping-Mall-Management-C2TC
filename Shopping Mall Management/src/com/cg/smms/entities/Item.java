package com.cg.smms.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private int ItemId;

	private String name;
	private LocalDate manufacturing;
	private LocalDate expiry;
	private float price;
	private String category;

	@ManyToOne // M:1
	@JoinColumn(name = "shopId") // FK
	private Shop shop;// shop

	/* ------------------- GS------------------- */

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getManufacturing() {
		return manufacturing;
	}

	public void setManufacturing(LocalDate manufacturing) {
		this.manufacturing = manufacturing;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Item [ItemId=" + ItemId + ", name=" + name + ", manufacturing=" + manufacturing + ", expiry=" + expiry
				+ ", price=" + price + ", category=" + category + ", shop=" + shop + "]";
	}

}
