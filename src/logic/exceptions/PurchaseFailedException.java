package logic.exceptions;

import logic.generators.base.Generator;
import logic.upgrades.base.Upgrade;

public class PurchaseFailedException extends Exception {

	public PurchaseFailedException(Generator generator) {
		System.err.println("Error while buying generator called " + generator.getName() + " - Not enough cookies!");
	}

	public PurchaseFailedException(Upgrade upgrade, int errorType) {
		String errorMessage = "";
		switch (errorType) {
		case 0:
			errorMessage = "Upgrade level already maxed";
			break;
		case 1:
			errorMessage = "Not enough generators";
			break;
		case 2:
			errorMessage = "Not enough cookies";
			break;
		case 3:
			errorMessage = "Not enough handmade cookies";
			break;
		default:
			errorMessage = "Unknown Error";
			break;
		}
		System.err.println("Error while buying upgrade called " + upgrade.getName() + " - " + errorMessage + "!");
	}
}
