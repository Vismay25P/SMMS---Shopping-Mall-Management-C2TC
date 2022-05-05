package com.cg.smms.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "mall")
public class Mall implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private int mallId;

	private String mallName;
	private String location;
	private String categories;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "mallAdminId") // FK
	private MallAdmin mallAdmin;

//	@OneToMany(mappedBy = "current table name", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "mall", cascade = CascadeType.ALL)
	private List<Shop> shop = new ArrayList<>();

	/* ------------------- GS------------------- */

	public int getMallId() {
		return mallId;
	}

	public void setMallId(int mallId) {
		this.mallId = mallId;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public MallAdmin getMallAdmin() {
		return mallAdmin;
	}

	public void setMallAdmin(MallAdmin mallAdmin) {
		this.mallAdmin = mallAdmin;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
//
//	@Override
//	public String toString() {
//		return "Mall [mallId=" + mallId + ", mallName=" + mallName + ", location=" + location + ", categories="
//				+ categories + ", mallAdmin=" + mallAdmin + ", shop=" + shop + "]";
//	}

}
