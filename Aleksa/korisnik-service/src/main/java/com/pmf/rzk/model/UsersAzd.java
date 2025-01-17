package com.pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the UsersAzd database table.
 * 
 */
@Entity
@NamedQuery(name="UsersAzd.findAll", query="SELECT u FROM UsersAzd u")
public class UsersAzd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal balance;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String email;

	private String name;

	private String password;

	public UsersAzd() {
	}

	public UsersAzd( BigDecimal balance,String email, String name, String password) {
		super();
		this.balance = balance;
		this.email = email;
		this.name = name;
		this.password = password;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}