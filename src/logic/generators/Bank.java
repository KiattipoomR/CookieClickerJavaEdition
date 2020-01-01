package logic.generators;

import logic.PathStorage;
import logic.generators.base.Generator;

public class Bank extends Generator {

	private static final Bank INSTANCE = new Bank();
	
	private Bank() {
		super("Bank", "1400000", "1400", PathStorage.BANK_PATH);
	}
	
	public static Bank getInstance() {
		return INSTANCE;
	}

}
