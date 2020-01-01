package logic;

import java.math.BigDecimal;

public class Player implements Upgradable {

	private static final Player INSTANCE = new Player();
	private static final BigDecimal UPGRADE_MULTIPLIER = new BigDecimal("4");

	private String playerName;
	private BigDecimal currentCookies;
	private BigDecimal totalPerSecond;
	private int totalClick;
	private int totalGenerators;
	private BigDecimal totalCookies;
	private BigDecimal handmadeCookies;
	private BigDecimal perClick;

	private Player() {
		this.playerName = "Master Clicker";
		this.totalClick = 0;
		this.totalCookies = BigDecimal.ZERO;
		this.totalPerSecond = BigDecimal.ZERO;
		this.handmadeCookies = BigDecimal.ZERO;
		this.currentCookies = BigDecimal.ZERO;
		this.perClick = BigDecimal.ONE;
		this.totalGenerators = 0;
	}

	public void clickCookie() {
		this.currentCookies = this.currentCookies.add(this.perClick);
		this.handmadeCookies = this.handmadeCookies.add(this.perClick);
		this.totalCookies = this.totalCookies.add(this.perClick);
		this.totalClick++;
	}

	@Override
	public void upgrade() {
		setPerClick(getPerClick().multiply(UPGRADE_MULTIPLIER));
	}
	
	public static Player getInstance() {
		return INSTANCE;
	}

	public String getPlayerName() {
		return playerName;
	}

	public BigDecimal getCurrentCookies() {
		return currentCookies;
	}

	public BigDecimal getTotalPerSecond() {
		return totalPerSecond;
	}

	public int getTotalClick() {
		return totalClick;
	}

	public int getTotalGenerators() {
		return totalGenerators;
	}

	public BigDecimal getTotalCookies() {
		return totalCookies;
	}

	public BigDecimal getHandmadeCookies() {
		return handmadeCookies;
	}

	public BigDecimal getPerClick() {
		return perClick;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setCurrentCookies(BigDecimal currentCookies) {
		this.currentCookies = currentCookies;
	}

	public void setTotalCookies(BigDecimal totalCookies) {
		this.totalCookies = totalCookies;
	}

	public void setTotalPerSecond(BigDecimal totalPerSecond) {
		this.totalPerSecond = totalPerSecond;
	}

	public void setTotalGenerators(int totalGenerators) {
		this.totalGenerators = totalGenerators;
	}

	public void setPerClick(BigDecimal perClick) {
		this.perClick = perClick;
	}
}
