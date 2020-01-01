package application;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import logic.PathStorage;

public class HPanel extends HBox {

	private static final double BOX_HEIGHT = 16;

	// Constructor
	public HPanel() {

		BackgroundImage hPanel = new BackgroundImage(new Image(PathStorage.HPANEL_PATH), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		this.setPrefHeight(BOX_HEIGHT);
		this.setBackground(new Background(hPanel));
	}
}
