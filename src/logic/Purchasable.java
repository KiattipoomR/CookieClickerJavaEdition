package logic;

import logic.exceptions.PurchaseFailedException;

public interface Purchasable {
	public void buy() throws PurchaseFailedException;
}
