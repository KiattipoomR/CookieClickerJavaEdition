package application;

import java.math.BigDecimal;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.PathStorage;
import logic.PrintBigNum;
import logic.generators.base.Generator;

public class GeneratorDescriptionBox extends VBox {

	private static final double BOX_WIDTH = 190;
	private static final double BOX_HEIGHT = 50;
	private static final Color GREEN = Color.web("#61F161FF");
	private static final Color RED = Color.web("#FF6666FF");

	private Label name;
	private Label amount;
	private Label price;

	public GeneratorDescriptionBox(Generator generator) {
		name = new Label(generator.getName());
		amount = new Label();
		setAmount(generator.getAmountOwned());
		price = new Label();
		setBuyPrice(generator.getCurrentPrice());

		ImageView cookieIcon = new ImageView(new Image(PathStorage.ICON_PATH));
		HBox nameAndAmount = new HBox();
		HBox iconAndPrice = new HBox();

		name.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
		name.setTextFill(Color.WHITESMOKE);
		name.setEffect(new DropShadow(5, Color.BLACK));

		amount.setStyle("-fx-font-size: 12px;");

		price.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
		price.setEffect(new DropShadow(3, Color.BLACK));

		nameAndAmount.setAlignment(Pos.BASELINE_LEFT);
		nameAndAmount.setSpacing(5);

		iconAndPrice.setAlignment(Pos.CENTER_LEFT);
		iconAndPrice.setSpacing(5);

		nameAndAmount.getChildren().addAll(name, amount);
		iconAndPrice.getChildren().addAll(cookieIcon, price);

		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
		this.setAlignment(Pos.CENTER_LEFT);
		this.getChildren().addAll(nameAndAmount, iconAndPrice);
	}

	public void setBuyPrice(BigDecimal price) {
		this.price.setTextFill(GREEN);
		this.price.setText(PrintBigNum.PrintBigNumForCookie(price));
	}

	public void setSellPrice(BigDecimal price) {
		this.price.setTextFill(RED);
		this.price.setText(PrintBigNum.PrintBigNumForCookie(price));
	}

	public void setAmount(int amount) {
		this.amount.setText(amount + "x");
	}
}
