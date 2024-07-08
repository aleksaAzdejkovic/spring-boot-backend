package com.pmf.rzk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the gamesAzd database table.
 * 
 */
@Entity
@Table(name="gamesAzd")
@NamedQuery(name="GamesAzd.findAll", query="SELECT g FROM GamesAzd g")
public class GamesAzd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="away_odds")
	private BigDecimal awayOdds;

	@Column(name="draw_odds")
	private BigDecimal drawOdds;

	@Column(name="home_odds")
	private BigDecimal homeOdds;

	private String name;

	//bi-directional many-to-one association to BetsAzd
	@OneToMany(mappedBy="gamesAzd")
	@JsonIgnore
	private List<BetsAzd> betsAzds;

	public GamesAzd() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAwayOdds() {
		return this.awayOdds;
	}

	public void setAwayOdds(BigDecimal awayOdds) {
		this.awayOdds = awayOdds;
	}

	public BigDecimal getDrawOdds() {
		return this.drawOdds;
	}

	public void setDrawOdds(BigDecimal drawOdds) {
		this.drawOdds = drawOdds;
	}

	public BigDecimal getHomeOdds() {
		return this.homeOdds;
	}

	public void setHomeOdds(BigDecimal homeOdds) {
		this.homeOdds = homeOdds;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BetsAzd> getBetsAzds() {
		return this.betsAzds;
	}

	public void setBetsAzds(List<BetsAzd> betsAzds) {
		this.betsAzds = betsAzds;
	}

	public BetsAzd addBetsAzd(BetsAzd betsAzd) {
		getBetsAzds().add(betsAzd);
		betsAzd.setGamesAzd(this);

		return betsAzd;
	}

	public BetsAzd removeBetsAzd(BetsAzd betsAzd) {
		getBetsAzds().remove(betsAzd);
		betsAzd.setGamesAzd(null);

		return betsAzd;
	}

}