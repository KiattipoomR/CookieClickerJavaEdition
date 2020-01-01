package logic.generators.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

import logic.Player;
import logic.Purchasable;
import logic.Upgradable;
import logic.exceptions.PurchaseFailedException;
import logic.exceptions.SellFailedException;

public abstract class Generator implements Purchasable, Upgradable {

	protected static final BigDecimal BUY_MULTIPLIER = new BigDecimal("1.15");
	protected static final BigDecimal SELL_MULTIPLIER = new BigDecimal("0.25");
	protected static final BigDecimal UPGRADE_MULTIPLIER = new BigDecimal("2");

	protected String name;
	protected int amountOwned;
	protected BigDecimal currentPrice;
	protected BigDecimal sellPrice;
	protected BigDecimal currentPerSecond;
	protected BigDecimal totalPerSecond;
	protected String imagePath;

	protected Generator(String name, String price, String perSecond, String imagePath) {
		this.name = name;
		this.amountOwned = 0;
		this.currentPrice = new BigDecimal(price);
		this.sellPrice = BigDecimal.ZERO;
		this.currentPerSecond = new BigDecimal(perSecond);
		this.totalPerSecond = BigDecimal.ZERO;
		this.imagePath = imagePath;
	}

	public void buy() throws PurchaseFailedException {
		if (Player.getInstance().getCurrentCookies().compareTo(currentPrice) == -1)
			throw new PurchaseFailedException(this);
		else {
			Player.getInstance().setCurrentCookies(Player.getInstance().getCurrentCookies().subtract(currentPrice));
			Player.getInstance().setTotalPerSecond(Player.getInstance().getTotalPerSecond().add(currentPerSecond));
			Player.getInstance().setTotalGenerators(Player.getInstance().getTotalGenerators() + 1);
			amountOwned++;
			totalPerSecond = totalPerSecond.add(currentPerSecond);
			currentPrice = currentPrice.multiply(BUY_MULTIPLIER).setScale(0, RoundingMode.DOWN);
			sellPrice = currentPrice.multiply(SELL_MULTIPLIER).setScale(0, RoundingMode.DOWN);
		}
	}

	public void sell() throws SellFailedException {
		if (this.amountOwned == 0)
			throw new SellFailedException(this);
		else {
			Player.getInstance().setCurrentCookies(Player.getInstance().getCurrentCookies().add(sellPrice));
			Player.getInstance().setTotalPerSecond(Player.getInstance().getTotalPerSecond().subtract(currentPerSecond));
			Player.getInstance().setTotalGenerators(Player.getInstance().getTotalGenerators() - 1);
			amountOwned--;
			totalPerSecond = totalPerSecond.subtract(currentPerSecond);
			currentPrice = currentPrice.divide(BUY_MULTIPLIER, RoundingMode.UP);
			sellPrice = amountOwned == 0 ? BigDecimal.ZERO : currentPrice.multiply(SELL_MULTIPLIER).setScale(0, RoundingMode.DOWN);
		}
	}

	@Override
	public void upgrade() {
		Player.getInstance().setTotalPerSecond(Player.getInstance().getTotalPerSecond().add(totalPerSecond));
		currentPerSecond = currentPerSecond.multiply(UPGRADE_MULTIPLIER);
		totalPerSecond = currentPerSecond.multiply(new BigDecimal(amountOwned));
	}

	public String getName() {
		return name;
	}

	public int getAmountOwned() {
		return amountOwned;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public BigDecimal getCurrentPerSecond() {
		return currentPerSecond;
	}

	public BigDecimal getTotalPerSecond() {
		return totalPerSecond;
	}

	public String getImagePath() {
		return imagePath;
	}
}
