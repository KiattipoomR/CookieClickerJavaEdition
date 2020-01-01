package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.PathStorage;

public class BuyAndSellMenu extends HBox {
	
	private static final BuyAndSellMenu INSTANCE = new BuyAndSellMenu();
	private static final double BOX_WIDTH = 300;
	private static final double BOX_HEIGHT = 32;
	private static int mode = 0;
	
	private BuyAndSellMenu() {
		Label buy = new Label("BUY");
		Label sell = new Label("SELL");

		BackgroundImage blackBar = new BackgroundImage(new Image(PathStorage.BLACKBAR_PATH), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		buy.setTextFill(Color.WHITE);
		buy.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
		buy.setPrefHeight(BOX_HEIGHT);
		buy.setPrefWidth(BOX_WIDTH / 2);
		buy.setAlignment(Pos.CENTER);
		buy.setEffect(new Glow(1));

		buy.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (mode != 0)
					buy.setEffect(new Glow(1));
			}
		});

		buy.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (mode != 0)
					buy.setEffect(null);
			}
		});

		buy.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mode = 0;
				GeneratorBlock.setBuyAll();
				buy.setEffect(new Glow(1));
				sell.setEffect(null);
			}
		});

		sell.setTextFill(Color.WHITE);
		sell.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
		sell.setPrefHeight(BOX_HEIGHT);
		sell.setPrefWidth(BOX_WIDTH / 2);
		sell.setAlignment(Pos.CENTER);

		// set effects on "SELL" label
		sell.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (mode != 1)
					sell.setEffect(new Glow(1));
			}
		});

		sell.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (mode != 1)
					sell.setEffect(null);
			}
		});

		sell.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mode = 1;
				GeneratorBlock.setSellAll();
				sell.setEffect(new Glow(1));
				buy.setEffect(null);
			}
		});

		this.setPrefWidth(BOX_WIDTH);
		this.setPrefHeight(BOX_HEIGHT);
		this.setAlignment(Pos.CENTER);
		this.setBackground(new Background(blackBar));
		this.getChildren().addAll(buy,sell);
	}

	public static BuyAndSellMenu getInstance() {
		return INSTANCE;
	}
	
	public static int getMode() {
		return mode;
	}
}
