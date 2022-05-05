package com.cg.smms.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mallAdmin")
public class MallAdmin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private int mallAdminId;

	private String phone;

	@OneToOne(mappedBy = "mallAdmin") // 1:1
	private Mall mall;

	@OneToOne(cascade = CascadeType.ALL) // 1:1
	@JoinColumn(name = "userId") // FK
	private User user;

	/* ------------------- GS------------------- */

	public int getMallAdminId() {
		return mallAdminId;
	}

	public void setMallAdminId(int mallAdminId) {
		this.mallAdminId = mallAdminId;
	}

	public Mall getMall() {
		return mall;
	}

	public void setMall(Mall mall) {
		this.mall = mall;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MallAdmin [mallAdminId=" + mallAdminId + ", phone=" + phone + ", mall=" + mall + ", user=" + user + "]";
	}

}
