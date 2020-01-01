package application;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.PathStorage;

public class MenuBar extends BorderPane {

	private static final MenuBar INSTANCE = new MenuBar();
	
	private StackPane leftSide;
	private StackPane rightSide;

	private MenuBar() {
		leftSide = new StackPane();
		rightSide = new StackPane();
		Label leftText = new Label("Generators");
		Label rightText = new Label("Upgrades");

		leftText.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		leftText.setTextFill(Color.WHITESMOKE);
		leftText.setEffect(new DropShadow(10, Color.BLACK));

		leftSide.getChildren().addAll(new ImageView(new Image(PathStorage.LEFTMENU_PATH)), leftText);

		rightText.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		rightText.setTextFill(Color.WHITESMOKE);
		rightText.setEffect(new DropShadow(10, Color.BLACK));

		rightSide.getChildren().addAll(new ImageView(new Image(PathStorage.RIGHTMENU_PATH)), rightText);

		setLeft(leftSide);
		setRight(rightSide);
	}
	
	public static MenuBar getInstance() {
		return INSTANCE;
	}

}
