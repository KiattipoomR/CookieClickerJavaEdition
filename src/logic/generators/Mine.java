package logic.generators;

import logic.PathStorage;
import logic.generators.base.Generator;

public class Mine extends Generator {

	private static final Mine INSTANCE = new Mine();
	
	private Mine() {
		super("Mine", "12000", "57", PathStorage.MINE_PATH);
	}
	
	public static Mine getInstance() {
		return INSTANCE;
	}
}
