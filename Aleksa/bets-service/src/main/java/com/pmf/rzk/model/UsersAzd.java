package com.pmf.rzk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


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

	//bi-directional many-to-one association to BetsAzd
	@OneToMany(mappedBy="usersAzd")
	@JsonIgnore
	private List<BetsAzd> betsAzds;

	public UsersAzd() {
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

	public List<BetsAzd> getBetsAzds() {
		return this.betsAzds;
	}

	public void setBetsAzds(List<BetsAzd> betsAzds) {
		this.betsAzds = betsAzds;
	}

	public BetsAzd addBetsAzd(BetsAzd betsAzd) {
		getBetsAzds().add(betsAzd);
		betsAzd.setUsersAzd(this);

		return betsAzd;
	}

	public BetsAzd removeBetsAzd(BetsAzd betsAzd) {
		getBetsAzds().remove(betsAzd);
		betsAzd.setUsersAzd(null);

		return betsAzd;
	}

}