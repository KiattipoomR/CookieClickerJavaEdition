package application;

import javafx.scene.layout.VBox;
import logic.generators.Bank;
import logic.generators.Cursor;
import logic.generators.Factory;
import logic.generators.Farm;
import logic.generators.Grandma;
import logic.generators.Mine;

public class GeneratorBlock extends VBox {

	private static final GeneratorBlock INSTANCE = new GeneratorBlock();
	private static final double BOX_WIDTH = 300;

	private static GeneratorTile cursorTile;
	private static GeneratorTile grandmaTile;
	private static GeneratorTile farmTile;
	private static GeneratorTile mineTile;
	private static GeneratorTile factoryTile;
	private static GeneratorTile bankTile;

	private GeneratorBlock() {

		cursorTile = new GeneratorTile(Cursor.getInstance());
		grandmaTile = new GeneratorTile(Grandma.getInstance());
		farmTile = new GeneratorTile(Farm.getInstance());
		mineTile = new GeneratorTile(Mine.getInstance());
		factoryTile = new GeneratorTile(Factory.getInstance());
		bankTile = new GeneratorTile(Bank.getInstance());

		this.setPrefWidth(BOX_WIDTH);
		this.getChildren().addAll(BuyAndSellMenu.getInstance(), cursorTile, grandmaTile, farmTile, mineTile, factoryTile, bankTile);
	}

	public static void setBuyAll() {
		cursorTile.setBuy();
		grandmaTile.setBuy();
		farmTile.setBuy();
		mineTile.setBuy();
		factoryTile.setBuy();
		bankTile.setBuy();
	}

	public static void setSellAll() {
		cursorTile.setSell();
		grandmaTile.setSell();
		farmTile.setSell();
		mineTile.setSell();
		factoryTile.setSell();
		bankTile.setSell();
	}
	
	public static GeneratorBlock getInstance() {
		return INSTANCE;
	}
}
