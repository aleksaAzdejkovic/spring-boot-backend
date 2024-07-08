package com.pmf.rzk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the betsAzd database table.
 * 
 */
@Entity
@Table(name="betsAzd")
@NamedQuery(name="BetsAzd.findAll", query="SELECT b FROM BetsAzd b")
public class BetsAzd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="bet_amount")
	private BigDecimal betAmount;

	@Column(name="bet_type")
	private String betType;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String name;

	private BigDecimal odds;

	private String status;

	//bi-directional many-to-one association to UsersAzd
	@ManyToOne
	@JoinColumn(name="user_id")
	private UsersAzd usersAzd;

	//bi-directional many-to-one association to GamesAzd
	@ManyToOne
	@JoinColumn(name="game_id")
	private GamesAzd gamesAzd;

	public BetsAzd() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBetAmount() {
		return this.betAmount;
	}

	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}

	public String getBetType() {
		return this.betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOdds() {
		return this.odds;
	}

	public void setOdds(BigDecimal odds) {
		this.odds = odds;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public UsersAzd getUsersAzd() {
		return this.usersAzd;
	}

	public void setUsersAzd(UsersAzd usersAzd) {
		this.usersAzd = usersAzd;
	}
	
	public GamesAzd getGamesAzd() {
		return this.gamesAzd;
	}

	public void setGamesAzd(GamesAzd gamesAzd) {
		this.gamesAzd = gamesAzd;
	}

}