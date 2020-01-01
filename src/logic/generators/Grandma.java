package logic.generators;

import logic.PathStorage;
import logic.generators.base.Generator;

public class Grandma extends Generator {

	private static final Grandma INSTANCE = new Grandma();
	
	private Grandma() {
		super("Grandma", "100", "1", PathStorage.GRANDMA_PATH);
	}
	
	public static Grandma getInstance() {
		return INSTANCE;
	}
}
