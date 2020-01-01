package logic.generators;

import logic.PathStorage;
import logic.generators.base.Generator;

public class Farm extends Generator {

	private static final Farm INSTANCE = new Farm();
	
	private Farm() {
		super("Farm", "1100", "8", PathStorage.FARM_PATH);
	}
	
	public static Farm getInstance() {
		return INSTANCE;
	}
}
