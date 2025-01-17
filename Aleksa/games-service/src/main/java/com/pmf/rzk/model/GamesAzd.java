package com.pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


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

}