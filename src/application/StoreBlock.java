package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StoreBlock extends VBox {

	private static final StoreBlock INSTANCE = new StoreBlock();
	private static final double BOX_WIDTH = 300;

	private StoreBlock() {
		this.setPrefWidth(BOX_WIDTH);
		this.setAlignment(Pos.TOP_CENTER);

		Label store = new Label("Store");

		store.setStyle("-fx-font-size: 30px;");
		store.setTextFill(Color.WHITE);
		store.setEffect(new DropShadow());
		store.setPrefHeight(60);

		HPanel hPanel = new HPanel();
		HPanel hPanel2 = new HPanel();

		MenuBar.getInstance().getLeft().setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				INSTANCE.getChildren().removeAll(GeneratorBlock.getInstance(), UpgradeBlock.getInstance());
				INSTANCE.getChildren().add(GeneratorBlock.getInstance());
			}
		});

		MenuBar.getInstance().getRight().setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				INSTANCE.getChildren().removeAll(GeneratorBlock.getInstance(), UpgradeBlock.getInstance());
				INSTANCE.getChildren().add(UpgradeBlock.getInstance());
			}
		});

		this.getChildren().addAll(store, hPanel, MenuBar.getInstance(), hPanel2, GeneratorBlock.getInstance());
	}
	
	public static StoreBlock getInstance() {
		return INSTANCE;
	}

}
