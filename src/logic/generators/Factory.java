package logic.generators;

import logic.PathStorage;
import logic.generators.base.Generator;

public class Factory extends Generator {

	private static final Factory INSTANCE = new Factory();
	
	private Factory() {
		super("Factory", "130000", "260", PathStorage.FACTORY_PATH);
	}
	
	public static Factory getInstance() {
		return INSTANCE;
	}
}
