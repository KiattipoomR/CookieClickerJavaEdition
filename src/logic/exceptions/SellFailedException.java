package logic.exceptions;

import logic.generators.base.Generator;

public class SellFailedException extends Exception {

	public SellFailedException(Generator generator) {
		System.err.println("Error while selling " + generator.getName() + " - No " + generator.getName() + " to sell!");
	}
}
